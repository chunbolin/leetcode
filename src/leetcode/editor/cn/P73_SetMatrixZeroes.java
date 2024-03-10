//给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。 
//
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
//输出：[[1,0,1],[0,0,0],[1,0,1]]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[0].length 
// 1 <= m, n <= 200 
// -2³¹ <= matrix[i][j] <= 2³¹ - 1 
// 
//
// 
//
// 进阶： 
//
// 
// 一个直观的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。 
// 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。 
// 你能想出一个仅使用常量空间的解决方案吗？ 
// 
//
// Related Topics 数组 哈希表 矩阵 👍 1031 👎 0


package leetcode.editor.cn;
import java.util.*;

/**
 * 矩阵置零
 * @author DY
 * @date 2024-03-10 20:28:09
 */
public class P73_SetMatrixZeroes {
	public static void main(String[] args) {
		//测试代码
		Solution solution = new P73_SetMatrixZeroes().new Solution();
		int[][] matrix = new int[][]{{1,2,3,4}, {5,0,5,2}, {8,9,2,0}, {5,7,2,1}};
		solution.setZeroes(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public void setZeroes(int[][] matrix) {
			int firstI = -1, firstJ = -1;
			for (int i = 0; i < matrix.length; i++) {
				if (firstI != -1) break;
				for (int j = 0; j < matrix[0].length; j++) {
					if (matrix[i][j] == 0) {
						firstI = i;
						firstJ = j;
						break;
					}
				}
			}
			if (firstI == -1) return;
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					if (matrix[i][j] == 0) {
						matrix[firstI][j] = 0;
						matrix[i][firstJ] = 0;
					}
				}
			}
			for (int i = 0; i < matrix.length; i++) {
				if (matrix[i][firstJ] == 0) {
					for (int j = 0; j < matrix[0].length; j++) {
						if (i == firstI || j == firstJ) continue;
						matrix[i][j] = 0;
					}
				}
			}
			for (int i = 0; i < matrix[0].length; i++) {
				if (matrix[firstI][i] == 0) {
					for (int j = 0; j < matrix.length; j++) {
						if (i == firstJ || j == firstI) continue;
						matrix[j][i] = 0;
					}
				}
			}
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][firstJ] = 0;
			}
			for (int i = 0; i < matrix[0].length; i++) {
				matrix[firstI][i] = 0;
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

