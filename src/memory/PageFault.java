/* It is in this file, specifically the replacePage function that will
   be called by MemoryManagement when there is a page fault.  The 
   users of this program should rewrite PageFault to implement the 
   page replacement algorithm.
*/

  // This PageFault file is an example of the FIFO Page Replacement 
  // Algorithm as described in the Memory Management section.

import java.util.*;
//import Page;

public class PageFault {


  public static void replacePage (ArrayList<Page> lru, Vector mem , int virtPageNum , int replacePageNum , ControlPanel controlPanel )
  {



    Page page=lru.get(0);
    lru.remove(0);



    Page replacePage = ( Page ) mem.elementAt( replacePageNum );
    controlPanel.removePhysicalPage( page.id );
    replacePage.physical=page.physical;
    controlPanel.addPhysicalPage( replacePage.physical , replacePageNum );
    page.inMemTime = 0;
    page.lastTouchTime = 0;
    page.R = 0;
    page.M = 0;
    page.physical = -1;
    lru.add(replacePage);
  }
}
