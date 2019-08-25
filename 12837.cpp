//boj-12837
#include<bits/stdc++.h>
#define MAX_N 1000000
using namespace std;
typedef long long ll;
ll n, q;
vector<ll> tree, input;
ll init(vector<ll> &tree, vector<ll> &input, ll node, ll start, ll end)
{
	if (start == end)
		return tree[node] = input[start];
	ll mid = (start + end) >> 1;
	return tree[node] = init(tree, input, node * 2, start, mid) + init(tree, input, node * 2 + 1, mid + 1, end);
}
ll update(ll pos, ll cost, ll node, ll start, ll end)
{
	if (pos < start || end < pos)
		return tree[node];
	if (start == end)
		return tree[node] += cost;
	ll mid = (start + end) >> 1;
	return tree[node] = update(pos, cost, node * 2, start, mid) + update(pos, cost, node * 2 + 1, mid + 1, end);
}
ll query(ll low, ll high, ll node, ll start, ll end)
{
	if (high < start || end < low)
		return 0;
	if (low <= start && end <= high)
		return tree[node];
	ll mid = (start + end) >> 1;
	return query(low, high, node * 2, start, mid) + query(low, high, node * 2 + 1, mid + 1, end);
}
int main()
{
	scanf("%lld %lld", &n, &q);
	tree.resize(4 * MAX_N);
	input.resize(4 * MAX_N);
	init(tree, input, 1, 1, n);
	for (int i = 1; i <= q; i++)
	{
		ll a, b, c;
		scanf("%lld %lld %lld", &a, &b, &c);
		if (a == 1)
			update(b, c, 1, 1, n);
		else
			printf("%lld\n", query(b, c, 1, 1, n));
	}
	return 0;
}