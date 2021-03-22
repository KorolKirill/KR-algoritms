import java.util.ArrayList;

public class SparseThreeDimensionalList {
//    ArrayList<T> values = new ArrayList<>();
//    ArrayList<Integer> X_coordinates = new ArrayList<>();
//    ArrayList<Integer> Y_coordinates = new ArrayList<>();
//    ArrayList<Integer> Z_coordinates = new ArrayList<>();

    private ArrayList<Node<Integer>> nodes = new ArrayList<>();

    public void set(Integer value, int x, int y, int z) {
        Node<Integer> temp = findNodeByIndexes(x, y, z);
        if (temp == null) {
            nodes.add(new Node<Integer>(value, x, y, z));
        } else {
            temp.value = value;
        }
    }

    public void sort_nonempty() {
        quickSort(nodes, 0, nodes.size() - 1);
    }

    private void quickSort(ArrayList<Node<Integer>> array, int low, int high) {
        if (array.size() == 0)
            return;
        if (low >= high)
            return;
        int middle = low + (high - low) / 2;
        int pivot = array.get(middle).value;
        int i = low, j = high;
        while (i <= j) {
            while (array.get(i).value < pivot) {
                i++;
            }
            while (array.get(j).value > pivot) {
                j--;
            }
            if (i <= j) {
                Node<Integer> current = array.get(i);
                Node<Integer> next = array.get(j);
                int tem = current.value;
                current.value = next.value;
                next.value = tem;
                array.set(i, current);
                array.set(j, next);
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(array, low, j);
        if (high > i)
            quickSort(array, i, high);
    }


    private void swapValues(Node<Integer> a,Node<Integer> b) {
        int temp = a.value;
        a.value=b.value;
        b.value = temp;
    }



    public void printList() {
        for (Node<Integer> node : nodes) {
            System.out.printf("Value : %s Coordinates [%d,%d,%d]\n",
                    node.value, node.x_coordinate, node.y_coordinate, node.z_coordinate);
        }
    }

    public Integer get(int x, int y, int z) {
        Node<Integer> result = findNodeByIndexes(x, y, z);
        return result == null ? null : result.value;
    }

    private Node<Integer> findNodeByIndexes(int x, int y, int z) {
        for (Node<Integer> node : nodes) {
            if (node.x_coordinate == x && node.y_coordinate == y && node.z_coordinate == z) {
                return node;
            }
        }
        return null;
    }


    private class Node<Integer> {
        public Node(int value, int x_coordinate, int y_coordinate, int z_coordinate) {
            this.value = value;
            this.x_coordinate = x_coordinate;
            this.y_coordinate = y_coordinate;
            this.z_coordinate = z_coordinate;
        }

        int value;
        int x_coordinate;
        int y_coordinate;
        int z_coordinate;
    }
}
