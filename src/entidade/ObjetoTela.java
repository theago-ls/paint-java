package entidade;

import java.awt.Color;
import java.awt.Shape;
import java.util.ArrayList;

public class ObjetoTela{
    private ArrayList<Ponto> linha;
    private Shape objeto;
    private boolean selecionado;
    private Color cor;
    private boolean isLinha;
    private int sequencial;
    private String tipo;
    
    public ObjetoTela(int sequencial ,Shape objeto, boolean selecionado, Color cor, boolean isLinha, String tipo){
        this.sequencial = sequencial;
        this.objeto = objeto;
        this.selecionado = selecionado;
        this.cor = cor;
        this.isLinha = isLinha;
        this.tipo = tipo;
    }
    
    public ObjetoTela(int sequencial, ArrayList<Ponto> linha, boolean selecionado, Color cor, boolean isLinha, String tipo){
        this.sequencial = sequencial;
        this.linha = linha;
        this.selecionado = selecionado;
        this.cor = cor;
        this.isLinha = isLinha;
        this.tipo = tipo;
    }
    
    public Shape getObjeto(){
        return objeto;
    }
    
    public ArrayList<Ponto> getLinha(){
        return linha;
    }
    
    public boolean isLinha(){
        return isLinha;
    }
    
    public void setObjeto(Shape objeto){
        this.objeto = objeto;
    }
    
    public boolean isSelecionado(){
        return selecionado;
    }
    
    public Color getCor(){
        return cor;
    }
    
    public void setCor(Color cor){
        this.cor = cor;
    }
    
    public void setSelecionado(boolean selecionado){
        this.selecionado = selecionado;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public String toString(){
        String dados;        
        dados = "\n\n\n      Tipo de objeto: "+tipo+".\n      Cor: "+corToString()+".\n      Altura: "+objeto.getBounds().height+" pixels.\n      Largura: "+objeto.getBounds().width+" pixels.";
        return dados;
    }
    
    public String toStringLinha(){
        String dados;        
        dados = "\n\n\n      Tipo de objeto: "+tipo+".\n      Cor: "+corToString()+".\n      Altura: "+linhaAltura()+" pixels.\n      Largura: "+linhaLargura()+" pixels.";
        return dados;
    }
    
    private String corToString(){
        String ncor = "RGB ["+cor.getRed()+","+cor.getGreen()+","+cor.getBlue()+"]";
        return ncor;
    }
    
    private int linhaAltura() {
        int yMax = 0, yMin = 0;
        
        for(Ponto ponto: linha){            
            if(ponto.y > yMax)
                yMax = (int) ponto.y;            
            if(ponto.y < yMin)
                yMin = (int) ponto.y;
        }
        
        return yMax - yMin;
    }
    
    private int linhaLargura() {
        int xMax = 0, xMin = 0;
        
        for(Ponto ponto: linha){            
            if(ponto.x > xMax)
                xMax = (int) ponto.x;            
            if(ponto.x < xMin)
                xMin = (int) ponto.x;
        }
        
        return xMax - xMin;
    }
}
