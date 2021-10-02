

#include <bits/stdc++.h>
using namespace std;

// Rat in a Maze Problem (Backtracking)

// Consider a rat placed at (0, 0) in a square matrix of order N * N. 
// It has to reach the destination at (N - 1, N - 1). 
// Find all possible paths that the rat can take to reach from source to destination. 
// The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). 
// Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it 
// while value 1 at a cell in the matrix represents that rat can be travel through it. 

// Input:
// N = 4
// m[][] = {{1, 0, 0, 0},
//          {1, 1, 0, 1}, 
//          {1, 1, 0, 0},
//          {0, 1, 1, 1}}
// Output:
// DDRDRR DRDDRR
// Explanation:
// The rat can reach the destination at 
// (3, 3) from (0, 0) by two paths - DRDDRR 
// and DDRDRR, when printed in sorted order 
// we get DDRDRR DRDDRR.

class Solution{
    public:
    
void find(vector<vector<int>> &m,string s,int n,int i,int j,vector<string> &ans)
    {
        if(i==n-1&&j==n-1)
        {
            ans.push_back(s);
            return;
        }
        if(i>=0&&j>=0&&i<n&&j<n&&m[i][j])
        {
            m[i][j]=0;
            find(m, s + "D", n, i + 1, j, ans);
            find(m, s + "L", n, i, j - 1, ans);
            find(m, s + "R", n, i, j + 1, ans);
            find(m, s + "U", n, i - 1, j, ans);
            m[i][j]=1;
        }
        return;
        
    }
    
    vector<string> findPath(vector<vector<int>> &m, int n) {
        
        vector<string> ans;
        string s;
        if(m[0][0]==0||m[n-1][n-1]==0)
        return ans;
        
        find(m,s,n,0,0,ans);
        return ans;
     
    }
};

    




int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<vector<int>> m(n, vector<int> (n,0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cin >> m[i][j];
            }
        }
        Solution obj;
        vector<string> result = obj.findPath(m, n);
        if (result.size() == 0)
            cout << -1;
        else
            for (int i = 0; i < result.size(); i++) cout << result[i] << " ";
        cout << endl;
    }
    return 0;
}  