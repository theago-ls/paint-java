package entidade;


public class Quadrado extends java.awt.geom.Rectangle2D.Float{
    
    public Quadrado(float x, float y, float width, float height) {            
        setFrame(x, y, width, height);
    }        

    public void addX(float x) {            
        this.x += x;
    }
        
    public void addY(float y) {            
        this.y += y;
    }    
}
