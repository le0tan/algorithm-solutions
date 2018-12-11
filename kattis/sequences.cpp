#include <cstdio>
#include <cstring>
#define maxn 510000
#define max(a,b) a>b?a:b
typedef long long ll;
using namespace std;

const ll mod = 1e9+7;
const ll inv = 5e8+4;

ll add2pow(ll a, int e) {
    ll p = 1;
    while(e > 0) {
        p = (p*2) % mod;
        e--;
    }
    return (p+a) % mod;
}

int main() {
    char s[maxn]="????0???";
    int zeros[maxn];
    int ones[maxn];
    int marks[maxn];
    int zero=0,one=0,mark=0;
    int k=0;
    ll ans = 0;
    memset(zeros,0,sizeof(zeros));
    memset(ones,0,sizeof(ones));
    memset(marks,0,sizeof(marks));
    // scanf("%s",s);
    while(s[k] != '\0') {
        switch(s[k]) {
            case '0': {
                zero += 1;
                break;
            }
            case '1': {
                one += 1;
                break;
            }
            case '?': {
                mark += 1;
                break;
            }
            default: break;
        }
        zeros[k] = zero;
        ones[k] = one;
        marks[k] = mark;
        k++;
    }
    int po[200000];
    int pp[200000];
    po[0] = 1;
    pp[0] = 1;
    for(int i=1;i<200000;i++) {
        po[i] = (po[i-1] + po[i-1]) % mod;
        pp[i] = (po[i] + pp[i]) % mod;
    }
    for(int i=0;i<k;i++) {
        if(s[i] != '0') {
            int m = zero - zeros[i];
            int n = mark - marks[i];
            int p2 = add2pow(0, n);
            ans = (ans+((p2%mod)*(m%mod))%mod)%mod;
            int tt = add2pow(0, n-1);
            ans = (ans + tt * (n % mod)) % mod;
        }
    }
    // printf("%d %d %d\n",zero,one,mark);
    printf("%lld",ans);
    // printf("%lld", add2pow(0,1));
    return 0;
}