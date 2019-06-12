# Mastermind

## Performance

### pick first from remaining

`def pickFirst = remainingPerms.head`

```
Iterations for all permutations (iterations, number of maker's):
(8,12)
(7,91)
(6,334)
(5,672)
(4,150)
(3,31)
(2,5)
(1,1)
Score:5.247685
```

### Pick middle from remaining

`def pickMiddle = remainingPerms(remainingPerms.length / 2)`

```
(6,52)
(5,488)
(4,614)
(3,130)
(2,11)
(1,1)
Score:4.3371916
```

### Pick one third from remaining

`def pickTwoThird = remainingPerms(remainingPerms.length / 3)`

```
(6,31)
(5,428)
(4,666)
(3,159)
(2,11)
(1,1)
Score:4.236111
```
