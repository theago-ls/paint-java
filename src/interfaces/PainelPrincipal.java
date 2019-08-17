package interfaces;

import entidade.Elipse;
import entidade.ObjetoTela;
import entidade.Ponto;
import entidade.Quadrado;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JPanel;


public class PainelPrincipal extends JPanel implements MouseListener, MouseMotionListener{
      
    public enum Tool{lapis,quadrado,circulo,elipse,selecionar,mover};
    private int x1, y1, x2, y2, x, y, w, h, ax, ay, sequencial = 0;
    private double diametro;    
    private Tool tool = Tool.lapis;
    private Graphics2D g2d;
    private BufferedImage fundo;
    private Color cor = Color.GRAY;
    private ArrayList<ObjetoTela> objetos = new ArrayList();
    private Shape circulo, quadrado, elipse, aShape = new Elipse(0,0,1,1);
    private ArrayList<Ponto> aux = new ArrayList(), pontos = new ArrayList(); 
    private ObjetoTela objaux;
    ArrayList<String> informacoes = new ArrayList();
     
    public PainelPrincipal(){   
       this.setVisible(true);
       this.setFocusable(true);
       this.addMouseListener(this);
       this.addMouseMotionListener(this);       
    }  
         
    @Override
    public void paintComponent(Graphics g){     
        if(fundo == null){
            super.paintComponent(g);
            fundo = new BufferedImage(getSize().width,getSize().height,BufferedImage.TYPE_INT_RGB);
            g2d = (Graphics2D) fundo.getGraphics();            
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(Color.white);
            g2d.fillRect(0, 0, this.getSize().width, this.getSize().height);
            clear();
        }        
        g.drawImage(fundo, 0, 0, getWidth(), getHeight(), this);       
    }
        
    public void setarCor(Color cor){
        this.cor = cor;
        for(ObjetoTela objeto : objetos){
            if(objeto.isSelecionado()){
                objeto.setCor(cor);
            }
        }
        repaint2();
    }
            
    public void setTool(int forma){
        if(forma == 1){
            this.tool = Tool.quadrado;
        }
        if(forma == 2){
            this.tool = Tool.circulo;
        }
        if(forma == 3){
            this.tool = Tool.elipse;
        }
        if(forma == 4){
            this.tool = Tool.lapis;
        }
        if(forma == 5){
            this.tool = Tool.mover;
        }
        if(forma == 6){
            this.tool = Tool.selecionar;
        }
        if(forma == 7){         
            deletar();
        }   
    }
    
    public void deletar(){
        Iterator<ObjetoTela> itr = objetos.iterator();
        while(itr.hasNext()){
            if(itr.next().isSelecionado())
                itr.remove();
        }
        informacoes.clear();
        repaint2();
    }   
     
    public void clear(){
        g2d.setPaint(Color.white);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        repaint();
        objetos.clear();
        informacoes.clear();
    }
    
    public double calcRaio(){
        double dx, dy;
        dx = (x2-x1);
        dy = (y2-y1);        
        return Math.hypot(dx,dy);
    }
     
    @Override
    public void mouseClicked(MouseEvent e){
        if(tool == Tool.selecionar){
            selecionarObjeto(e.getX(),e.getY());                   
        }
        g2d.setColor(cor);
    }  
    
    public ObjetoTela selecionarObjeto(int x, int y){
        ObjetoTela obj = null;
        boolean ocupado = false;
        ArrayList<Ponto> linha = new ArrayList();
        int i;
        
        if(x != ax && y != ay){
            return objaux;
        }

        for(i = objetos.size()-1 ; i >= 0; i--){
            Ponto ponto = new Ponto(x,y);
            if(!objetos.get(i).isSelecionado()){
                if(!(objetos.get(i).isLinha())){
                    if(objetos.get(i).getObjeto().contains(ponto)){                    
                        obj = objetos.get(i);
                        g2d.setColor(obj.getCor().brighter());
                        g2d.fill(obj.getObjeto());
                        objetos.get(i).setSelecionado(true);
                        informacoes.add(objetos.get(i).toString());
                        ocupado = true;
                        break;                    
                    }
                } else {
                    linha = objetos.get(i).getLinha();                
                    if((linha.contains(ponto))){
                        for(Point2D pontos : linha){
                            g2d.setColor(objetos.get(i).getCor().brighter());
                            x =(int)pontos.getX();
                            y =(int)pontos.getY();
                            g2d.drawLine(x,y,x,y);                        
                        }
                        objetos.get(i).setSelecionado(true);
                        informacoes.add(objetos.get(i).toStringLinha());
                        obj = objetos.get(i);
                        ocupado = true;
                        break;
                    }
                }           
            }
        }
        if(!ocupado){
            for(ObjetoTela objeto: objetos){
                if(objeto.isSelecionado()){                    
                    objeto.setSelecionado(false);                
                }            
            }
            informacoes.clear();
        }
        repaint2();
        return obj;
    }
    
    public void pintar(Shape shape){
        g2d.setColor(cor);
        g2d.fill(shape);
    }   
       
    @Override
    public void mouseReleased(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();

        x = Math.min(x1,x2);
        y = Math.min(y1,y2);
        w = Math.abs(x2-x1);
        h = Math.abs(y2-y1);
        
        if((Math.abs(x2-ax) > 0) && (Math.abs(y2-ay) > 0)){
        if(tool == Tool.lapis){
            pontos.add(new Ponto(x1,y1));           
            sequencial++;            
            ObjetoTela objeto = new ObjetoTela(sequencial,pontos,false,cor,true,"Pincel");
            objetos.add(objeto);
            pontos = new ArrayList();            
        }
        if(tool == Tool.circulo){
            sequencial++;
            diametro = calcRaio(); 
            Elipse circulo = new Elipse(x,y,(float)diametro,(float)diametro);
            pintar(circulo);
            objetos.add(new ObjetoTela(sequencial,circulo,false,cor,false,"Círculo"));
            aShape = new Ellipse2D.Float(0,0,1,1);
        }        
        if(tool == Tool.quadrado){
            sequencial++;
            Quadrado quadrado = new Quadrado(x,y,w,h);
            pintar(quadrado);
            objetos.add(new ObjetoTela(sequencial,quadrado,false,cor,false,"Quadrado"));
            aShape = new Elipse(0,0,1,1);
        }
        if(tool == Tool.elipse){
            sequencial++;
            Elipse elipse = new Elipse(x,y,w,h);
            pintar(elipse);
            objetos.add(new ObjetoTela(sequencial,elipse,false,cor,false,"Elipse"));
            aShape = new Elipse(0,0,1,1);
        }        
        if(tool == Tool.mover){ 
                objaux = selecionarObjeto(x1,y1);
                if(objaux != null){
                    aShape = objaux.getObjeto();
                    float dx, dy;                                       
                    dx = x2 - x1;
                    dy = y2 - y1;                    
                    if(objaux.getTipo().equals("Quadrado")){                       
                       g2d.setColor(Color.white);
                       g2d.fill(aShape);
                       g2d.setColor(Color.yellow);
                       Quadrado quadrado = (Quadrado) aShape;
                       quadrado.addX(dx);
                       quadrado.addY(dy);
                       g2d.fill(quadrado);                       
                    }
                    if(objaux.getTipo().equals("Círculo")){                       
                       Elipse elipse = (Elipse) aShape; 
                       g2d.setColor(Color.white);
                       g2d.fill(aShape);
                       elipse.addX(dx);
                       elipse.addY(dy);
                       g2d.setColor(Color.yellow);                       
                       g2d.fill(elipse);                                        
                    }
                    if(objaux.getTipo().equals("Elipse")){
                       g2d.setColor(Color.white);
                       g2d.fill(aShape);
                       Elipse elipse = (Elipse) aShape;                                          
                       g2d.setColor(Color.yellow);
                       elipse.addX(dx);
                       elipse.addY(dy);
                       g2d.fill(elipse);  
                    }
                    if(objaux.isLinha()){                                                
                        for(Ponto ponto : objaux.getLinha()){
                            g2d.setColor(Color.white);
                            g2d.drawLine((int)ponto.getX(),(int)ponto.getY(),(int)ponto.getX(),(int)ponto.getY());
                            ponto.addX(dx);
                            ponto.addY(dy);
                            g2d.setColor(Color.yellow);
                            g2d.drawLine((int)ponto.getX(),(int)ponto.getY(),(int)ponto.getX(),(int)ponto.getY());
                        }   
                    }
                    repaint2();                   
                }
        }        
        repaint(); 
        }
    }
         
    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {        
    }

    @Override
    public void mouseMoved(MouseEvent e) {        
    }    
    
    @Override
    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
        if(tool == Tool.selecionar){
            selecionarObjeto(e.getX(),e.getY());
            g2d.setColor(cor);
        }     
        ax = x1;
        ay = y1;       
    }
    
    public void repaint2(){
        ArrayList<Ponto> linha = new ArrayList();
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, getSize().width, getSize().height);
        for(ObjetoTela objeto : objetos){                       
            if(objeto.isLinha()){                
                linha = objeto.getLinha();
                if(objeto.isSelecionado()){
                    g2d.setColor(objeto.getCor().brighter());
                    for(Ponto ponto : linha){                 
                        x = (int)ponto.getX();
                        y = (int)ponto.getY();                       
                        g2d.drawLine(x,y,x,y);
                    }
                }else{
                    g2d.setColor(objeto.getCor());
                    for(Ponto ponto : linha){                        
                        x = (int)ponto.getX();
                        y = (int)ponto.getY();
                        g2d.drawLine(x,y,x,y);
                    }
                }                
            }else{
                if(!objeto.isSelecionado()){
                    g2d.setColor(objeto.getCor());
                    g2d.fill(objeto.getObjeto());
                }else{
                    g2d.setColor(objeto.getCor().brighter());
                    g2d.fill(objeto.getObjeto());
                }
            }
        }
        repaint();        
    }
   
    @Override
    public void mouseDragged(MouseEvent e){
        x2 = e.getX();
        y2 = e.getY();      
        
        w = Math.abs(x2-x1);
        h = Math.abs(y2-y1);
        
        g2d = (Graphics2D) fundo.getGraphics();
        if(g2d != null){
            g2d.setColor(cor);
            if(tool == Tool.lapis){
                pontos.add(new Ponto(x1,y1));
                g2d.drawLine(x1, y1, x2, y2);                     
                repaint();
                x1 = x2;
                y1 = y2;
            }
            if(tool == Tool.quadrado){
                repaint2();
                g2d.setColor(Color.white);
                g2d.fill(aShape);
                g2d.setColor(cor);
                aShape = new Quadrado(Math.min(x1,x2),Math.min(y1,y2),(float)Math.abs(x2-x1),(float)Math.abs(y2-y1));
                g2d.fill(aShape);           
            }
            if(tool == Tool.circulo){
                repaint2();
                diametro = calcRaio();
                g2d.setColor(Color.white);
                g2d.fill(aShape);
                g2d.setColor(cor);
                aShape = new Elipse(Math.min(x1,x2),Math.min(y1,y2),(float)diametro,(float)diametro);
                g2d.fill(aShape);
            }
            if(tool == Tool.elipse){
                repaint2();
                diametro = calcRaio();                
                g2d.setColor(Color.white);
                g2d.fill(aShape);
                g2d.setColor(cor);
                aShape = new Elipse(Math.min(x1,x2),Math.min(y1,y2),(float)w,(float)h);
                g2d.fill(aShape);
            }
            if(tool == Tool.mover){                
                objaux = selecionarObjeto(x1,y1);
                if(objaux != null){                    
                    aShape = objaux.getObjeto();
                    float dx, dy;                    
                    dx = x2 - x1;
                    dy = y2 - y1;                    
                    if(objaux.getTipo().equals("Quadrado")){                       
                       g2d.setColor(Color.white);
                       g2d.fill(aShape);
                       g2d.setColor(objaux.getCor().brighter());
                       Quadrado quadrado = (Quadrado) aShape;
                       quadrado.addX(dx);
                       quadrado.addY(dy);
                       g2d.fill(quadrado);
                    }
                    if(objaux.getTipo().equals("Círculo")){                    
                       g2d.setColor(Color.white);
                       g2d.fill(aShape);
                       Elipse elipse = (Elipse) aShape;                                          
                       g2d.setColor(objaux.getCor().brighter());
                       elipse.addX(dx);
                       elipse.addY(dy);
                       g2d.fill(elipse);                                
                    }
                    if(objaux.getTipo().equals("Elipse")){                       
                       g2d.setColor(Color.white);
                       g2d.fill(aShape);
                       Elipse elipse = (Elipse) aShape;                                          
                       g2d.setColor(objaux.getCor().brighter());
                       elipse.addX(dx);
                       elipse.addY(dy);
                       g2d.fill(elipse);                                      
                    }
                    if(objaux.isLinha()){                                      
                        for(Ponto ponto : objaux.getLinha()){ 
                            g2d.setColor(Color.white);
                            g2d.drawLine((int)ponto.getX(),(int)ponto.getY(),(int)ponto.getX(),(int)ponto.getY());
                            ponto.addX(dx);
                            ponto.addY(dy); 
                            g2d.setColor(objaux.getCor().brighter());
                            g2d.drawLine((int)ponto.getX(),(int)ponto.getY(),(int)ponto.getX(),(int)ponto.getY());
                        }                                                
                    }
                    x1 = (int) (x1+dx);
                    y1 = (int) (y1+dy); 
                    repaint2();
                }
            }        
        }        
    }
    
    public ArrayList<String> getInfo(){
        return informacoes;
    }  
}  
                            

