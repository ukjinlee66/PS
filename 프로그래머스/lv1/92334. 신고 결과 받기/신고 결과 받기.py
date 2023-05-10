from collections import defaultdict
def solution(id_list, report, k):
    new_dict = {}
    report_dict = defaultdict(list)
    ans = []
    for c in id_list:
        new_dict[c] = 0
    new_report = list(set(report))
    for c in new_report:
        reporter, reported = c.split()
        new_dict[reported] += 1
        report_dict[reporter].append(reported)
    for n in id_list:
        cnt = 0
        for nn in report_dict[n]:
            if new_dict[nn] >= k:
                cnt+=1
        ans.append(cnt)
    return ans