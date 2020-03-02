# Connecting Dots
First I want to say that this was truly inspired by ViHart's Doodles which can be found [here.](https://www.youtube.com/watch?v=v-pyuaThp-c) I recommend to watch it because there are so many other amazing simple designs. This was my first GUI program done in Java for my AP Computer Science class in highschool

## Graph
<img src="https://github.com/ImaginaryResources/Connecting-Dots/blob/master/images/Graph1.png" height="600">

## Graph2
<img src="https://github.com/ImaginaryResources/Connecting-Dots/blob/master/images/Graph2.gif">

## Graph3
<img src="https://github.com/ImaginaryResources/Connecting-Dots/blob/master/images/Graph3.gif">

## Graph4
<img src="https://github.com/ImaginaryResources/Connecting-Dots/blob/master/images/Graph41.gif">
<img src="https://github.com/ImaginaryResources/Connecting-Dots/blob/master/images/Graph42.gif">

There's some really poor naming going on here but there's no acctual name I could find for this design

# The Code
Here is a simple snippet of code just to understand what's going on, that can be ran in [Processing](https://processing.org/) 
```java
void setup(){
    size(500, 500);
}

void draw(){
    translate(250, 250);
    
    int x = 250, y = 0;
    while(x > 0){
        x -= 10;
        y += 10;
      
        line(0 , y, x , 0);
        line(0 , y, -x , 0);
        line(0 , -y, x , 0);
        line(0 , -y, -x , 0);
    }
}
```

