package game;

import city.cs.engine.World;

public class Vec2 extends World {
    private double x, y;

    public Vec2(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Vec2(){
        x = 0;
        y = 0;
    }

    public void zero(){
        x = 0;
        y = 0;
    }


    public double dot(Vec2 v){
        return x*v.getX() + y*v.getY();
    }

    public boolean isZero(){
        if(x == 0 && y == 0)
            return true;
        return false;
    }

    public static double Distance(Vec2 a, Vec2 b){

        return a.substract(b).getMagnitude();
    }

    public Vec2 normalize(){
        return new Vec2(x / getMagnitude(), y / getMagnitude());
    }

    public Vec2 substract(Vec2 v){
        return new Vec2(x - v.getX(), y - v.getY());
    }

    public Vec2 add(Vec2 v){
        return new Vec2(x + v.getX(), y + v.getY());
    }

    public double getMagnitude(){
        return Math.sqrt(x*x + y*y);
    }


    public Vec2 multyplyByScalar(double scalar){
        x *= scalar;
        y *= scalar;
        return this;
    }
    public Vec2 divideByScalar(double scalar){
        x /= scalar;
        y /= scalar;
        return this;
    }

    public void truncate(double value){
        if(x > value)
            x = value;
        if(y > value )
            y = value;
        if(x < -value)
            x = -value;
        if(y < -value )
            y = -value;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String toString(){
        return "x: "+(int)x+" y: "+(int)y;
    }
}
