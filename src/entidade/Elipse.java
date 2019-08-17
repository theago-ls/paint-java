package entidade;

public class Elipse extends java.awt.geom.Ellipse2D.Float{
               
    public Elipse(float x, float y, float width, float height) {            
        setFrame(x, y, width, height);
    }        

    public void addX(float x) {            
        this.x += x;
    }
        
    public void addY(float y) {            
        this.y += y;
    }        
}
