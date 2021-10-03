#include<bits/stdc++.h>
using namespace std;

// Given a grid consisting of '0's(Water) and '1's(Land). Find the number of islands.
// An island is surrounded by water and is formed by connecting adjacent lands 
// horizontally or vertically or diagonally i.e., in all 8 directions.
 

class Solution
{
    
    
    void mark(vector<vector<char>> &matrix,int x,int y,int r,int c)
    {
        if(x<0 || x>=r || y<0 || y>=c || matrix[x][y]!='1')  
            return;
        
        
        matrix[x][y] = '2';
        
        
        mark(matrix,x+1,y,r,c);  
        mark(matrix,x,y+1,r,c);  
        mark(matrix,x-1,y,r,c);  
        mark(matrix,x,y-1,r,c); 
        mark(matrix,x-1,y-1,r,c);  
        mark(matrix,x+1,y+1,r,c);  
        mark(matrix,x+1,y-1,r,c);  
        mark(matrix,x-1,y+1,r,c); 
        
    }
    public:
    
    int numIslands(vector<vector<char>>& grid) 
    {
        
        int row=grid.size();
        if(row==0)    
        return 0;
        int col=grid[0].size();
        
        
        int ans=0;
        for(int i=0;i<row;++i)
        {
            for(int j=0;j<col;++j)
            {
                if(grid[i][j]=='1')
                {
                    mark(grid,i,j,row,col);
                    ans++;
                }
            }
        }
        return ans;
      
    }
};


int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n, m;
		cin >> n >> m;
		vector<vector<char>>grid(n, vector<char>(m, '#'));
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				cin >> grid[i][j];
			}
		}
		Solution obj;
		int ans = obj.numIslands(grid);
		cout << ans <<'\n';
	}
	return 0;
} 