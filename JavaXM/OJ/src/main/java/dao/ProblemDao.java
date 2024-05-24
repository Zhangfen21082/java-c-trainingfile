package dao;

import Util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProblemDao {
    public void insert(Problem problem) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DBUtil.getConnection();
            String sql = "insert into oj_table values(null, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, problem.getTitle());
            statement.setString(2, problem.getLevel());
            statement.setString(3, problem.getDescription());
            statement.setString(4, problem.getTemplateCode());
            statement.setString(5, problem.getTestCode());

            int ret = statement.executeUpdate();
            if(ret != 1) {
                System.out.println("题目新增失败");
            } else {
                System.out.println("题目新增成功");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }


    public void delete(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DBUtil.getConnection();
            String sql = "delete from oj_table where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int ret = statement.executeUpdate();
            if(ret != 1) {
                System.out.println("题目删除失败");
            } else {
                System.out.println("题目删除成功");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }

    }

    public List<Problem> selectAll() throws SQLException {
        List<Problem> problems = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();
            String sql = "select id, title, level from oj_table";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Problem problem = new Problem();
                problem.setId(resultSet.getInt("id"));
                problem.setTitle(resultSet.getString("title"));
                problem.setLevel(resultSet.getString("level"));
                problems.add(problem);

                return problems;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }

        return null;

    }

    public Problem selectOne(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();
            String sql = "select * from oj_table where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if(resultSet.next()) {
                Problem problem = new Problem();
                problem.setId(resultSet.getInt("id"));
                problem.setTitle(resultSet.getString("title"));
                problem.setLevel(resultSet.getString("level"));
                problem.setDescription(resultSet.getString("description"));
                problem.setTemplateCode(resultSet.getString("templateCode"));
                problem.setTestCode(resultSet.getString("testCode"));

                return problem;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }

        return null;
    }

    public static void testInsert() throws SQLException {
        ProblemDao problemDao = new ProblemDao();
        Problem problem = new Problem();
        problem.setTitle("两数之和");
        problem.setLevel("简单");
        problem.setDescription("给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。\n" +
                "\n" +
                "你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。\n" +
                "\n" +
                "你可以按任意顺序返回答案。\n" +
                "\n" +
                " \n" +
                "\n" +
                "示例 1：\n" +
                "\n" +
                "输入：nums = [2,7,11,15], target = 9\n" +
                "输出：[0,1]\n" +
                "解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。\n" +
                "示例 2：\n" +
                "\n" +
                "输入：nums = [3,2,4], target = 6\n" +
                "输出：[1,2]\n" +
                "示例 3：\n" +
                "\n" +
                "输入：nums = [3,3], target = 6\n" +
                "输出：[0,1]\n" +
                " ");
        problem.setTemplateCode("class Solution {\n" +
                "    public int[] twoSum(int[] nums, int target) {\n" +
                "\n" +
                "    }\n" +
                "}");
        problem.setTestCode("    public static void main(String[] args) {\n" +
                "        Solution solution = new Solution();\n" +
                "\n" +
                "        // testcase1;\n" +
                "        int[] nums = {2, 7, 11, 15};\n" +
                "        int target = 9;\n" +
                "        int[] result = solution.twoSum(nums,target);\n" +
                "        if(result.length == 2 && result[0] == 0 && result[1] == 1) {\n" +
                "            System.out.println(\"testcase1 success\");\n" +
                "        } else {\n" +
                "            System.out.println(\"testcase1 fail\");\n" +
                "        }\n" +
                "\n" +
                "        // testcase2;\n" +
                "        int[] nums2 = {3, 2, 4};\n" +
                "        int target2 = 6;\n" +
                "        int[] result2 = solution.twoSum(nums2, target2);\n" +
                "        if(result.length == 2 && result2[0] == 0 && result2[1] == 1) {\n" +
                "            System.out.println(\"testcase2 success\");\n" +
                "        } else {\n" +
                "            System.out.println(\"testcase2 fail\");\n" +
                "        }\n" +
                "\n" +
                "    }");

        problemDao.insert(problem);
    }

    public static void testSelectAll() throws SQLException {
        ProblemDao problemDao = new ProblemDao();
        List<Problem> problems = problemDao.selectAll();
        System.out.println(problems);
    }

    public static void testSelectOne() throws SQLException {
        ProblemDao problemDao = new ProblemDao();
        Problem problem = problemDao.selectOne(1);
        System.out.println(problem);

    }
    public static void testDelete() throws SQLException {
        ProblemDao problemDao = new ProblemDao();
        problemDao.delete(2);
    }

    public static void main(String[] args) throws SQLException {
        testInsert();
    }
}
