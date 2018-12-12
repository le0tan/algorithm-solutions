#include <cstdio>
using namespace std;
void rotate(int s[4][4]) {
	int t[4][4];
	for(int i=0;i<4;i++)
		for(int j=0;j<4;j++)
			t[3-j][i]=s[i][j];
	for(int i=0;i<4;i++)
		for(int j=0;j<4;j++)
			s[i][j]=t[i][j];
	return;
}
void move_left(int s[4][4]) {
	for(int i=0;i<4;i++){
		for(int j=1;j<4;j++){
			if(s[i][j-1]==0){
				int cur = s[i][j];
				s[i][j]=0;
				int k=j-1;
				while(s[i][k]==0 && k>=0){k--;}
				k++;
				s[i][k]=cur;
			}
		}
	}
	return;
}

void merge(int s[4][4]) {
	for(int i=0;i<4;i++){
		for(int j=0;j<3;j++){
			if(s[i][j]==s[i][j+1]){
				s[i][j]*=2;
				s[i][j+1]=0;
			}
		}
	}
	return;
}

int main(){
	int g[4][4];
	int op;
	for(int i=0;i<4;i++){
		for(int j=0;j<4;j++){
			scanf("%d",&g[i][j]);
		}
	}
	scanf("%d",&op);
	for(int i=0;i<op;i++) rotate(g);
	move_left(g);
	merge(g);
	move_left(g);
	for(int i=0;i<4-op;i++) rotate(g);
	for(int i=0;i<4;i++){
		for(int j=0;j<4;j++){
			printf("%d ",g[i][j]);
		}
		printf("\n");
	}
	return 0;
}
