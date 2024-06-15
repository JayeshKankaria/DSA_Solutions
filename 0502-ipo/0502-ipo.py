class Solution:
    def findMaximizedCapital(self, k: int, w: int, profits: List[int], capital: List[int]) -> int:
        maxProfit = []  # max-heap for the projects we can afford
        minCapital = [(c, p) for c, p in zip(capital, profits)]  # min-heap for projects by capital required
        heapq.heapify(minCapital)

        for i in range(k):
            # Move all projects we can afford from minCapital to maxProfit
            while minCapital and minCapital[0][0] <= w:
                c, p = heapq.heappop(minCapital)
                heapq.heappush(maxProfit, -p)  # push negative profit to create a max-heap

            # If there are no projects we can afford, break
            if not maxProfit:
                break

            # Pop the most profitable project we can afford
            w += -heapq.heappop(maxProfit)

        return w
