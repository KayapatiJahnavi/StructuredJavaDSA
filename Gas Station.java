class Solution {
    public int startStation(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        
        // If total gas is less than total cost, it's not possible to complete the circuit
        if (totalGas < totalCost) {
            return -1;
        }

        int currentGas = 0;
        int startStation = 0;
        for (int i = 0; i < gas.length; i++) {
            currentGas += gas[i] - cost[i];
            if (currentGas < 0) {
                currentGas = 0;
                startStation = i + 1;
            }
        }
        
        return startStation;
    }
    }
