#include <bits/stdc++.h>
using namespace std;
#define ll long long int
#define rep(i,j,n) for(ll i=j;i<n;i++)
const int mod = 1e9+7;
ll gcd(ll a,ll b){ return a?gcd(b%a,a):b; }
ll minv(ll a,ll b){ return a<b?a:b;}
ll maxv(ll a,ll b){ return a>b?a:b;}
void swapv(ll &a,ll &b){a=a+b;b=a-b;a=a-b;}
ll power(ll a, ll b, ll m=mod){
    if(a==0 || b==1) return a;
    if(b==0) return 1;
    ll ans=1;
    while(b>=1){ if(b&1){b--;ans = (ans*a) % m;}a = (a*a)% m;b = b>>1;}
    return ans;
}
ll inv(ll a,ll m){return power(a,m-2,m);}

int main() {
    ios_base::sync_with_stdio(false); 
    cin.tie(NULL);  
    #ifndef ONLINE_JUDGE 
        freopen("input.txt", "r", stdin); 
        freopen("output.txt", "w", stdout); 
    #endif 
    ll t=1;
    cin>>t;
    ll n,k;
    while(t--)
    {
        cin>>n>>k;
        ll a = 1<<(n-1);
        if(k>a) {cout<<"-1\n";continue;}
    }
    return 0;
}
