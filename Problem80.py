from decimal import *

setcontext(Context(prec=102))

ans = 0
for n in range(100):
    d = Decimal(n).sqrt()
    decimal_part = d.as_tuple().digits[:-2]
    ans += sum(decimal_part)
print(ans)
