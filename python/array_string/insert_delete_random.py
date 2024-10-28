import random


class RandomizedSet:
    def __init__(self) -> None:
        self.values = []
        self.indices = {}

    def insert(self, val: int) -> bool:
        if val in self.indices:
            return False

        self.indices[val] = len(self.values)

        self.values.append(val)

        return True

    def remove(self, val: int) -> bool:
        if val not in self.values:
            return False

        last_val = self.values[-1]
        index_to_remove = self.indices[val]

        self.values[index_to_remove] = last_val
        self.indices[last_val] = index_to_remove

        self.values.pop()

        del self.indices[val]

        return True

    def getRandom(self) -> int:
        return random.choice(self.values)
