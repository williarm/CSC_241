//----------------------------------------------------------------------
// Grid.java              by Dale/Joyce/Weems                  Chapter 3
//
// Supports grid objects consisting of blob and non-blob characters.
// Allows the number of blobs it contains to be counted.
//----------------------------------------------------------------------
package ch03.grids;

import ch05.queues.LinkedUnbndQueue;

public class Grid
{
  protected int rows;         // number of grid rows
  protected int cols;         // number of grid columns
    
  protected boolean [][] grid;     // the grid containing blobs
  boolean [][] visited;            // used by blobCount

  public Grid(boolean[][] g)
  // Preconditions: g is rectangular and non-empty
  //                i.e. all rows are the same size
  {
    grid = g;
    rows = g.length;
    cols = g[0].length;
  }

  public String toString()
  {
    String gridString = "";
    for (int i = 0; i < rows; i++)
    {
      for (int j = 0; j < cols; j++)
      {
        if (grid[i][j])
          gridString = gridString + "X";
        else
          gridString = gridString + "-";
       }
      gridString = gridString + "\n";   // end of row
    }  
    return gridString;
  }

  public int blobCount()
  // returns the number of blobs in this grid
  {
    int count = 0;
    visited = new boolean [rows][cols];  // true if location visited
        
    // initialize visited
    for (int i = 0; i < rows; i++)
      for (int j = 0; j < cols; j++)
        visited[i][j] = false;
      
    // count blobs
    for (int i = 0; i < rows; i++)
      for (int j = 0; j < cols; j++)
        if (grid[i][j] && !visited[i][j])
        {
          count++;
          markBlob(i, j); 
        }
       
    return count;
  }
  
  private void markBlob(int row, int col)
  // Mark position row, col as having been visited.
  // Check and if appropriate mark locations above, below, left,
  // and right of that position.
  {
    visited[row][col] = true;
   
    // check above
    if ((row - 1) >= 0)           // if its on the grid
      if (grid[row - 1][col])       // and has a blob character
        if (!visited[row - 1][col])   // and has not been visited
          markBlob(row - 1, col);       // then mark it
    
    // check below
    if ((row + 1) < rows)        // if its on the grid
      if (grid[row + 1][col])       // and has a blob character
        if (!visited[row + 1][col])   // and has not been visited
          markBlob(row + 1, col);       // then mark it
    
    // check left
    if ((col - 1) >= 0)           // if its on the grid
      if (grid[row][col - 1])       // and has a blob character
        if (!visited[row][col - 1])   // and has not been visited
          markBlob(row, col - 1);       // then mark it
    
    // check right
    if ((col + 1) < cols)        // if its on the grid
      if (grid[row][col + 1])       // and has a blob character
        if (!visited[row][col + 1])   // and has not been visited
          markBlob(row, col + 1);       // then mark it
  }
  
   public int blobCount2()
  // returns the number of blobs in this grid
  {
    int count = 0;
    int r, c;
    visited = new boolean [rows][cols];  // true if location visited
    
    LinkedUnbndQueue<Integer> rowQ = new LinkedUnbndQueue<Integer>();
    LinkedUnbndQueue<Integer> colQ = new LinkedUnbndQueue<Integer>();

    // initialize visited
    for (int i = 0; i < rows; i++)
      for (int j = 0; j < cols; j++)
        visited[i][j] = false;
      
    // count blobs
    for (int i = 0; i < rows; i++)
      for (int j = 0; j < cols; j++)
        if (grid[i][j] && !visited[i][j])
        {
          count++;
          visited[i][j] = true;
          rowQ.enqueue(i);
          colQ.enqueue(j);
          while (!rowQ.isEmpty())
          {
             r = rowQ.dequeue();
             c = colQ.dequeue();
             
    // check above
    if ((r - 1) >= 0)           // if its on the grid
      if (grid[r - 1][c])       // and has a blob character
        if (!visited[r - 1][c])   // and has not been visited
        { 
          visited[r-1][c] = true;
          rowQ.enqueue(r-1);
          colQ.enqueue(c);
        }
    
    // check below
    if ((r + 1) < rows)        // if its on the grid
      if (grid[r + 1][c])       // and has a blob character
        if (!visited[r + 1][c])   // and has not been visited
        { 
          visited[r+1][c] = true;
          rowQ.enqueue(r+1);
          colQ.enqueue(c);
        }
    
    // check left
    if ((c - 1) >= 0)           // if its on the grid
      if (grid[r][c - 1])       // and has a blob character
        if (!visited[r][c - 1])   // and has not been visited
        { 
          visited[r][c-1] = true;
          rowQ.enqueue(r);
          colQ.enqueue(c-1);
        }
    
    // check right
    if ((c + 1) < cols)        // if its on the grid
      if (grid[r][c + 1])       // and has a blob character
        if (!visited[r][c + 1])   // and has not been visited
        { 
          visited[r][c+1] = true;
          rowQ.enqueue(r);
          colQ.enqueue(c+1);
        }
     }
    }
       
    return count;
  }
  
   
}
