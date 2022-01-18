import java.util.Stack;

public class Codec {
    public String serialize(TreeNode root) {
        StringBuilder buffer = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                buffer.append("null");
            } else {
                buffer.append(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
            buffer.append(' ');
        }
        return buffer.toString();
    }

    public TreeNode deserialize(String data) {
        String[] items = data.split(" ");
        boolean goLeft = true;
        TreeNode root = null;
        Stack<TreeNode> branch = new Stack<>();
        for (String item : items) {
            TreeNode parsed = parseNode(item);
            if (root == null) {
                root = parsed;
                branch.push(parsed);
            } else {
                TreeNode parent = branch.pop();
                if (parsed != null) {
                    if (goLeft) {
                        parent.left = parsed;
                    } else {
                        parent.right  = parsed;
                    }
                    branch.push(parent);
                    branch.push(parsed);
                    goLeft = true;
                } else {
                    if (goLeft) {
                        goLeft = false;
                    } else {
                        if (!branch.isEmpty())
                        parent = branch.pop();
                        while (parent.right != null && !branch.isEmpty()) {
                            parent = branch.pop();
                        }
                    }
                    branch.push(parent);
                }
            }
        }
        return root;
    }

    private TreeNode parseNode(String item) {
        TreeNode parsed;
        if ("null".equals(item)) {
            parsed = null;
        } else {
            parsed = new TreeNode(Integer.parseInt(item));
        }
        return parsed;
    }
}