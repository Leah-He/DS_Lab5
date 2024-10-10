import java.util.Stack;

public class History
{

	Stack<Event> eventStorage = new Stack<>();
	Stack<Event> undoStorage = new Stack<>();

    /**
       Notepad will call this function when thier text changes.

       deletion is a boolean that indicates if the action was a deletion of text or the insertion of text.
       position is the postion where the change took place
       Change is the string of characters that is the change.
     */
   public void addEvent(boolean deletion, int position, String Change)
   {
	   Event newEvent = new Event(Change, position, deletion);
	   eventStorage.push(newEvent);
	   undoStorage.clear();
	   
   }


    /**
       Notepad will call this function when it wishes to undo the last event.

       note is a variable to the Notepad that called this function
     */
   public void undoEvent(NotePad note)
   {
	   
	   if (hasUndoData()) {
		   Event lastEvent = eventStorage.pop();
		   undoStorage.push(lastEvent);
		   if (lastEvent.checkDeletion()) {
			   note.insert(lastEvent.getPosition(), lastEvent.getEvent());
		   } else {
			   note.remove(lastEvent.getPosition(), lastEvent.getEvent().length());
		   }
		   
	   }
	   //System.out.println(undoStorage.peek());
   }


    /**
       Notepad will call this function when it wishes to redo the last event that was undone.
       Note that new actions should clear out events that can be "redone"
       note is a variable to the Notepad that called this function
     */
   public void redoEvent(NotePad note)
   {
	   if (hasReDoData()) {
		   Event lastUndo = undoStorage.pop();
		   eventStorage.push(lastUndo);
		   if (!lastUndo.checkDeletion()) {
			   note.insert(lastUndo.getPosition(), lastUndo.getEvent());
		   } else {
			   note.remove(lastUndo.getPosition(), lastUndo.getEvent().length());
		   }
		   //eventStorage.push(lastUndo);
	   }
   	
   }

    /**
       returns true if there is undo data in the History
     */
   public boolean hasUndoData()
   {
       return !eventStorage.isEmpty();
   }

    /**
       returns true if there is undo data in the History
     */
   public boolean hasReDoData()
   {
	   //System.out.println(undoStorage.isEmpty());
       return !undoStorage.isEmpty();//should use undoStorage instead of use eventStorage
   }
	

}
