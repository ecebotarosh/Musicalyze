package PaooGame.UI;

import PaooGame.Input.MouseManager;
import PaooGame.RefLinks;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UIManager {
        private ArrayList<UIObject> objects;
        private MouseManager mouseManager;
        private RefLinks reflink;
        public UIManager(RefLinks reflink)
        {
            objects=new ArrayList<>();
            this.reflink=reflink;
            this.mouseManager=reflink.GetMouseManager();
        }

        public void Update()
        {
            for(UIObject object : objects)
            {
                object.Update();
            }
        }

        public void Draw(Graphics g)
        {
            for(UIObject object : objects)
            {
                object.Draw(g);
            }
        }

        public void onMouseMove(MouseEvent e)
        {
            for(UIObject object : objects)
            {
                object.onMouseMove(e);
            }
        }

        public void onMouseRelease(MouseEvent e)
        {
            for(UIObject object : objects)
            {
                object.onMouseRelease(e);
            }
        }

        public void addObject(UIObject o)
        {
            objects.add(o);
        }

        public void removeObject(UIObject o)
        {
            if(objects.contains(o))
            {
                objects.remove(o);
            }
        }

        public ArrayList<UIObject> getObjects()
        {
            return objects;
        }
}
