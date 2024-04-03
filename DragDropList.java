import java.awt.*;

class DragDropList extends JTree implements DragGestureListener,DragSourceListener {    

   public DragTree() {

      DragSource dragSource = DragSource.getDefaultDragSource();


      // creating the recognizer is all that抯 necessary - it
      // does not need to be manipulated after creation
      dragSource.createDefaultDragGestureRecognizer(
         this, // component where drag originates
         DnDConstants.ACTION_COPY_OR_MOVE, // actions
         this); // drag gesture listener
         ...
      }
      public void dragGestureRecognized(DragGestureEvent e) {
         // drag anything ...
         e.startDrag(DragSource.DefaultCopyDrop, // cursor
            new StringSelection(getFilename()), // transferable
            this); // drag source listener
      }
      public void dragDropEnd(DragSourceDropEvent e) {}
      public void dragEnter(DragSourceDragEvent e) {}
      public void dragExit(DragSourceEvent e) {}
      public void dragOver(DragSourceDragEvent e) {}
      public void dropActionChanged(DragSourceDragEvent e) {}
      ...
   }   
