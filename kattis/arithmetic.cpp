#include <cstdio>
using namespace std;

char* toThree(char digit, char* res) {
	int num = digit-'0';
	for(int i=2; i>=0; i--) {
		res[i] = (num%2) + '0';
		num /= 2;
	}
	return res;
}

int toHex(char* bin, char* ans, int end) {
	int start = end-3 >= 0 ? end-3 : 0;
	char hex[] = "0123456789ABCDEF";
	bool ok = false;
	int pt = 0;
	while(!ok) {
		if(start == 0) ok = true;
		int mul = 1;
		int t = 0;
		for(int i=end;i>=start;i--) {
			t += mul * (bin[i] - '0');
			mul *= 2;
		}
		ans[pt++] = hex[t];
		end = start-1;
		start = end-3 >= 0 ? end-3 : 0;
	}
	ans[pt] = '\0';
	return pt;
}

int main() {
	char a[201000];
	char res[4] = "";
	char bin[610000] = "";
	int cur = 0;
	int p=0;
	bool lead = true;
	scanf("%s", a);
	while(a[p] != '\0') {
		toThree(a[p], res);
		int j=0;
		if(p == 0) {
			while(res[j] == '0') j++;
			for(int i=j; i<3; i++) {
				bin[cur++] = res[i];
			}
			p++;
		} else {
			for(int i=0;i<3;i++) {
				bin[cur+i] = res[i];
			}
			cur+=3; p++;
		}
	}
	char ans[201000];
	int len = toHex(bin, ans, cur-1);
	for(int i=len-1;i>=0;i--) printf("%c", ans[i]);
	return 0;
}
