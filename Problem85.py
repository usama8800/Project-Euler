def rectangles_in_grid(width, height):
    ret = 0
    for wi in range(1, width + 1):
        for hi in range(1, height + 1):
            ret += (width - (wi - 1)) * (height - (hi - 1))
    return ret


limit = int(2e6)
ans_recs = 0
ans_w = 0
ans_h = 0
ans_diff = limit
stop = False
for w in range(1, limit):
    if stop:
        break
    for h in range(w, limit):
        recs = rectangles_in_grid(w, h)
        diff = abs(recs - limit)
        if diff < ans_diff:
            ans_recs = recs
            ans_w = w
            ans_h = h
            ans_diff = diff
        if recs > limit:
            if h == w:
                stop = True
            break
print(ans_w, ans_h, ans_w * ans_h, ans_recs)
