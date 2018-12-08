#include <stdio.h>
#include <string.h>
#define MAXN 1000000

char ans[MAXN];

char* reader(char* pt, char* res){
    char tar = *pt;
    int flag = 1;
    int count = 0;
    while(flag){
        if(*pt == tar){
            count++;
            // printf("%d\n",count);
            pt++;
        } else {
            flag = 0;
        }
    }
    sprintf(res, "%d%c", count, tar);
    return pt;
}

char* findNextWritable(char* pt){
    while(*pt != '\0'){
        pt++;
    }
    return pt;
}

void say(char* a, char* res){
    memset(res,'\0',sizeof(res));
    char* read_pt = a;
    char* res_pt = res;
    while(*read_pt != '\0'){
        read_pt = reader(read_pt, res_pt);
        res_pt = findNextWritable(res_pt);
    }
    return;
}

void helper(int n, char* ans) {
    int i;
    char last[MAXN] = "1";
    char temp[MAXN];
    for(i = 1; i < n; i++){
        say(last, temp);
        memcpy(last, temp, sizeof(temp));
        // printf("%s\n", temp);
    }
    // printf("%s\n", last);
    memcpy(ans, last, sizeof(last));
    return;
}

char* countAndSay(int n){
    memset(ans, '\0', sizeof(ans));
    helper(n, ans);
    // printf("%s", ans);
    return ans;
}

int main(){
    // char ans[MAXN];
    // int n;
    // scanf("%d", &n);
    // helper(n, ans);
    // printf("%s", ans);
    printf("%s",countAndSay(20));
    return 0;
}