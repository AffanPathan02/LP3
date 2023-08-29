import timeit

lst=[]
lst2=[]
def fibonacci(n):
    lst.append(0)
    lst.append(1)
    for i in range(0,n-1):
        lst.append(lst[i]+lst[i+1])
    return lst

def fib_rec(n):
    if n == 0:
        return 0
    elif n == 1:
        return 1
    else:
        return fib_rec(n - 1) + fib_rec(n - 2)
    
n=int(input("Enter the Number:"))
print(fibonacci(n))

print("Time required : ",timeit.timeit("fibonacci(n)",setup=f"from __main__ import fibonacci;n={n}",number=100))

for i in range(0,n+1):
	lst2.append(fib_rec(i))
print(lst2)
print("Time required : ",timeit.timeit("fib_rec(n)",setup=f"from __main__ import fib_rec;n={n}",number=100))

