#include <bits/stdc++.h>
using namespace std;
typedef long long int ll;

main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    ll m;
    cin>>m;
    ll a = m/10;
    m -= a * 10;
    ll b = m/5;
    m -= b * 5;
    ll c = m;
    ll n = a + b + c;
    cout << n << endl;
}