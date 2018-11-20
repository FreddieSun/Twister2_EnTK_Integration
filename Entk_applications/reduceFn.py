import pandas as pd
from sys import argv

script, file = argv
data = open(file)

df = pd.read_csv(data, sep=" ", header=None, names=["a", "b", "c"])
sums = df.select_dtypes(pd.np.number).sum().rename('total')
df.append(sums)
df.loc['total'] = df.select_dtypes(pd.np.number).sum()
print(df)


