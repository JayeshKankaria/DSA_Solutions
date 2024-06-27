class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        # Top-Down Memoization
        cache = {}

        def dfs(i, j):
            # If the result for this state is already computed, return it
            if (i, j) in cache:
                return cache[(i, j)]

            # If both strings are fully matched
            if i >= len(s) and j >= len(p):
                return True

            # If the pattern is consumed but the string is not
            if j >= len(p):
                return False

            # Check if the current characters match
            match = i < len(s) and (s[i] == p[j] or p[j] == '.')

            # Handle '*' in the pattern
            if (j + 1) < len(p) and p[j + 1] == '*':
                # Two cases:
                # 1. We don't use '*' (skip two characters in the pattern)
                # 2. We use '*' (check the next character in the string if it matches)
                cache[(i, j)] = dfs(i, j + 2) or (match and dfs(i + 1, j))
                return cache[(i, j)]

            if match:
                # Proceed with the next characters in both the string and the pattern
                cache[(i, j)] = dfs(i + 1, j + 1)
                return cache[(i, j)]

            # If no match
            cache[(i, j)] = False
            return False

        # Start the recursion with both indices at 0
        return dfs(0, 0)
