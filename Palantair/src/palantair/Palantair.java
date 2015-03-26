/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package palantair;

// each node is graph is the location in the 2-D square
// for each node there is edge from node to its min-value neighbour, if min-value neighbour is less than this points elevation

// then what? DFS?
// two lists may intersect..
// reverse the edges and DFS?
// keep doind dfs until all the nodes are covered?

//why do we need to reverse the edges ?, we dont need to 
// can do without reversing 

// DFS is not required.. a node links to only one node.. so it is like linked list traversal!

class Node{
    int row;
    int column;
    
    Node (int x, int y){
        row=x;
        column=y;
    }
}

class Graph {
    int size=1000;
    int[][] elevation = new int[size][size];
    
    //String basin=""; //Basin name// Changed to int as After Z, naming is troublesome
    int[][] basin_number=new int[size][size];
    //boolean[][] visited=new boolean[size][size];  // DFS visited marker
    int number_of_basins=0;
    int[] basin_sizes= new int[size*size];

    void initialize (){
        for (int row=0; row<size; row++){
            for (int column=0; column<size; column++){
                //visited[row][column]=false;
                basin_number[row][column]=-1;
            }
        }
    }
    
    Node findMinNeighbour(Node input_node){
        // gives the min-neighbour
        // return self node if it is min        

        int row=input_node.row;
        int column=input_node.column;
        int elev = elevation[row][column];
        if ((row>0 && column>0)&&(row+1<size && column+1<size)){// not corner case, all neighbour exist
            // compare to top
            int top_elev=elevation[row-1][column];
            int bottom_elev=elevation[row+1][column];
            int left_elev=elevation[row][column-1];
            int right_elev=elevation[row][column+1];
            
            //case elev is min
            if ((elev<top_elev)&&(elev<bottom_elev)&&(elev<left_elev)&&(elev<right_elev)){
                row=input_node.row;
                column=input_node.column;
            }
            
            //case top elev is min
            else if ((top_elev<elev)&&(top_elev<bottom_elev)&&(top_elev<left_elev)&&(top_elev<right_elev)){
                row=input_node.row-1;
                column=input_node.column;                
            }
            
            //case bottom elev is min
            else if ((bottom_elev<top_elev)&&(top_elev<elev)&&(bottom_elev<left_elev)&&(bottom_elev<right_elev)){
                row=input_node.row+1;
                column=input_node.column;
            }

            //case left_elev is min
            else if ((left_elev<top_elev)&&(left_elev<bottom_elev)&&(left_elev<elev)&&(left_elev<right_elev)){
                row=input_node.row;
                column=input_node.column-1;
            }
            
            //case right_elev is min
            else if ((right_elev<top_elev)&&(top_elev<bottom_elev)&&(top_elev<left_elev)&&(top_elev<elev)){
                row=input_node.row;
                column=input_node.column+1;
            }
            
            return new Node(row,column);
        }
        else if (row==0){
            if (column==0){
                int bottom_elev=elevation[row+1][column];
                int right_elev=elevation[row][column+1];

                //elev is smallest
                if (elev<bottom_elev && elev<right_elev){
                    row=input_node.row;
                    column=input_node.column;
                }

                //bottom_elev is smallest
                else if (bottom_elev<elev && bottom_elev<right_elev){
                    row=input_node.row+1;
                    column=input_node.column;
                }
                
                //right_elev is smallest
                else if (right_elev<bottom_elev && right_elev<elev){
                    row=input_node.row;
                    column=input_node.column+1;
                }
                return new Node (row, column);
                }
            else if (column+1==size){
                int bottom_elev=elevation[row+1][column];
                int left_elev=elevation[row][column-1];

                if (elev<bottom_elev && elev<left_elev){
                    row=input_node.row;
                    column=input_node.column;
                }

                else if (bottom_elev<elev && bottom_elev<left_elev){
                    row=input_node.row+1;
                    column=input_node.column;
                }
                
                 else if (left_elev<bottom_elev && left_elev<elev){
                    row=input_node.row;
                    column=input_node.column-1;
                }
                return new Node (row, column);
                }
            else{
                int bottom_elev=elevation[row+1][column];
                int left_elev=elevation[row][column-1];
                int right_elev=elevation[row][column+1];

                //elev is smallest
                if (elev<bottom_elev && elev<left_elev && elev<right_elev){
                    row=input_node.row;
                    column=input_node.column;
                }
                else if (bottom_elev<elev && bottom_elev<left_elev && bottom_elev<right_elev){
                    row=input_node.row+1;
                    column=input_node.column;
                }
                else if (left_elev<bottom_elev && left_elev<elev && left_elev<right_elev){
                    row=input_node.row;
                    column=input_node.column-1;
                }
                else if (right_elev<bottom_elev && right_elev<left_elev && right_elev<elev){
                    row=input_node.row;
                    column=input_node.column+1;
                }
                return new Node (row, column);
            }
        }
        else if (column==0){
                if (row+1==size){
                    int top_elev=elevation[row-1][column];
                    int right_elev=elevation[row][column+1];

                    if (elev<top_elev && elev<right_elev){
                        row=input_node.row;
                        column=input_node.column;
                    }

                    else if (top_elev<elev && top_elev<right_elev){
                        row=input_node.row-1;
                        column=input_node.column;
                    }

                     else if (right_elev<top_elev && right_elev<elev){
                        row=input_node.row;
                        column=input_node.column+1;
                    }
                    return new Node (row, column);
                    }
                else{
                    int top_elev=elevation[row-1][column];
                    int bottom_elev=elevation[row+1][column];
                    int right_elev=elevation[row][column+1];
                    //elev is smallest
                    if (elev<bottom_elev && elev<top_elev && elev<right_elev){
                        row=input_node.row;
                        column=input_node.column;
                    }
                    else if (bottom_elev<elev && bottom_elev<top_elev && bottom_elev<right_elev){
                        row=input_node.row+1;
                        column=input_node.column;
                    }
                    else if (top_elev<bottom_elev && top_elev<elev && top_elev<right_elev){
                        row=input_node.row-1;
                        column=input_node.column;
                    }
                    else if (right_elev<bottom_elev && right_elev<top_elev && right_elev<elev){
                        row=input_node.row;
                        column=input_node.column+1;
                    }
                    return new Node (row, column);
                }

        }
        else if (row+1==size){
            if (column==0){
                int top_elev=elevation[row-1][column];
                int right_elev=elevation[row][column+1];

                if (elev<top_elev && elev<right_elev){
                    row=input_node.row;
                    column=input_node.column;
                }

                else if (top_elev<elev && top_elev<right_elev){
                    row=input_node.row-1;
                    column=input_node.column;
                }
                
                 else if (right_elev<top_elev && right_elev<elev){
                    row=input_node.row;
                    column=input_node.column+1;
                }
                return new Node (row, column);
                }
            else if (column+1==size){
                int top_elev=elevation[row-1][column];
                int left_elev=elevation[row][column-1];

                if (elev<top_elev && elev<left_elev){
                    row=input_node.row;
                    column=input_node.column;
                }

                else if (top_elev<elev && top_elev<left_elev){
                    row=input_node.row-1;
                    column=input_node.column;
                }
                
                 else if (left_elev<top_elev && left_elev<elev){
                    row=input_node.row;
                    column=input_node.column-1;
                }
                return new Node (row, column);
                }
            else{
                int top_elev=elevation[row-1][column];
                int left_elev=elevation[row][column-1];
                int right_elev=elevation[row][column+1];

                if (elev<top_elev && elev<left_elev && elev<right_elev){
                    row=input_node.row;
                    column=input_node.column;
                }
                else if (top_elev<elev && top_elev<left_elev && top_elev<right_elev){
                    row=input_node.row-1;
                    column=input_node.column;
                }
                else if (left_elev<top_elev && left_elev<elev && left_elev<right_elev){
                    row=input_node.row;
                    column=input_node.column-1;
                }
                else if (right_elev<top_elev && right_elev<left_elev && right_elev<elev){
                    row=input_node.row;
                    column=input_node.column+1;
                }
                return new Node (row, column);
            }
        }
        else if (column+1==size){
                int top_elev=elevation[row-1][column];
                int bottom_elev=elevation[row+1][column];
                int left_elev=elevation[row][column-1];

                if (elev<top_elev && elev<left_elev && elev<bottom_elev){
                    row=input_node.row;
                    column=input_node.column;
                }
                else if (top_elev<elev && top_elev<left_elev && top_elev<bottom_elev){
                    row=input_node.row-1;
                    column=input_node.column;
                }
                else if (left_elev<top_elev && left_elev<elev && left_elev<bottom_elev){
                    row=input_node.row;
                    column=input_node.column-1;
                }
                else if (bottom_elev<top_elev && bottom_elev<left_elev && bottom_elev<elev){
                    row=input_node.row+1;
                    column=input_node.column;
                }
                return new Node (row, column);
        }
        return new Node (row, column);// error case
    }
    
    int getBasin(Node given_node){
        Node current_node=given_node;
        Node smallest_neightbour=findMinNeighbour(given_node);
        int basin=-1;
        while (!(current_node.row==smallest_neightbour.row && current_node.column==smallest_neightbour.column)){
            if (basin_number[smallest_neightbour.row][smallest_neightbour.column]>-1){
                basin=basin_number[smallest_neightbour.row][smallest_neightbour.column];
                break;
            }
            current_node=smallest_neightbour;
            smallest_neightbour=findMinNeighbour(given_node);
        }
        if (basin>-1){
            return basin;
        }
        else{
            basin_number[current_node.row][current_node.column]=number_of_basins;
            basin=number_of_basins;
            number_of_basins++;
        }
        return basin;
    }
    
    void doTraversal (Node given_node){
        int basin=getBasin(given_node);
        
        Node current_node=given_node;
        Node smallest_neightbour=findMinNeighbour(given_node);
        basin_number[current_node.row][current_node.column]=basin;

        while (!(current_node.row==smallest_neightbour.row && current_node.column==smallest_neightbour.column)){
            if (basin_number[smallest_neightbour.row][smallest_neightbour.column]>-1){
                break;
            }
            else{
                basin_number[smallest_neightbour.row][smallest_neightbour.column]=basin;
            }
            current_node=smallest_neightbour;
            smallest_neightbour=findMinNeighbour(given_node);
        }
    }

    void completeBasinComputation (){
        for (int row =0; row <size; row ++){
            for (int column=0; column<size; column++){
                Node current_node = new Node (row, column);
                doTraversal(current_node);
            }
        }
    }
    
    void printBasins(){
        System.out.println();
        for (int row=0; row<size; row++){
            for (int column=0; column<size; column++){
                System.out.print(basin_number[row][column]+",  ");
            }
            System.out.println();
        }
        
    }
   
}


public class Palantair {

    public static void main(String[] args) {

        /**
         Input:
           3
           1 5 2
           2 4 7
           3 6 9
      The basins, labeled with A’s and B’s, are:
           A A B
           A A B
           A A A
 
      */
        Graph test = new Graph();
        test.initialize();

        //test 1;
        test.size=3;
        test.elevation[0][0]=1;
        test.elevation[0][1]=5;
        test.elevation[0][2]=2;
        test.elevation[1][0]=2;
        test.elevation[1][1]=4;
        test.elevation[1][2]=7;
        test.elevation[2][0]=3;
        test.elevation[2][1]=6;
        test.elevation[2][2]=9;
        test.completeBasinComputation();
        System.out.println("test1");
        test.printBasins();
        System.out.println("----------");

        test.size=1;
        test.elevation[0][0]=10;
        test.completeBasinComputation();
        System.out.println("test2");
        test.printBasins();
        System.out.println("----------");
    
    }    
}
