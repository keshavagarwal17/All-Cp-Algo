#include<bits/stdc++.h>
#include <iostream>

using namespace std;

// Given an expression string x. Examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
// For example, the function should return 'true' for exp = “[()]{}{[()()]()}” and 'false' for exp = “[(])”.
bool ispar(string expr)
{
    
    stack<char> s; 
    char x; 
  
    for (int i = 0; i < expr.length(); i++)  
    { 
        if (expr[i] == '(' || expr[i] == '['
            || expr[i] == '{')  
        { 
            s.push(expr[i]); 
            continue; 
        } 
  
        if (s.empty()) 
            return false; 
  
        switch (expr[i]) { 
        case ')': 
              
            x = s.top(); 
            s.pop(); 
            if (x == '{' || x == '[') 
                return false; 
            break; 
  
        case '}': 
  
            x = s.top(); 
            s.pop(); 
            if (x == '(' || x == '[') 
                return false; 
            break; 
  
        case ']': 
            x = s.top(); 
            s.pop(); 
            if (x == '(' || x == '{') 
                return false; 
            break; 
        } 
    } 
  
   
    return (s.empty()); 
  
}



int main()
{
    string s;
    cin>>s;
    
    if(ispar(s))
    cout<<"Balanced"<<endl;
    else
    cout<<"Not Balanced"<<endl;

    return 0;
}
