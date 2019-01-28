#include <cstdio>
using namespace std;

int prev[100100];
int next[100100];

int main() {
	int s,b;
	scanf("%d%d",&s,&b);
	while(s!=0||b!=0) {
		for(int i=1;i<=s;i++) {
			prev[i] = i-1;
			next[i] = i+1;
		}
		prev[1] = -1;
		next[s] = -1;
		for(int i=0;i<b;i++) {
			int l,r;
			scanf("%d%d",&l,&r);
			if(prev[l]!=-1) {
				next[prev[l]] = next[r];
				printf("%d ",prev[l]);
			} else {
				printf("* ");
			}
			if(next[r]!=-1) {
				prev[next[r]] = prev[l];
				printf("%d",next[r]);
			} else {
				printf("*");
			}
			printf("\n");
		}
		printf("-\n");
		scanf("%d%d",&s,&b);
	}
	return 0;
}
