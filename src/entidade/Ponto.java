package entidade;

import java.awt.geom.Point2D;

public class Ponto extends Point2D.Float{
    
    public Ponto(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void addX(float x) {            
        this.x += x;
    }
        
    public void addY(float y) {            
        this.y += y;
    }    
}
