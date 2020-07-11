学习笔记

HashMap数据结构：数组+链表/红黑树，用到了：散列算法
1、核心方法put、remove、replace、resize
2、初始化容量为16（不指定容量初始化，默认为16，如果指定的数组容量为奇数 会转化为最接近的2的n次方容量），负载英子为0.75扩容的时候 会根据负载英子 和当前Node数组容量作为判断依据
3、链表转为红黑树需满足的条件：数组容量大于等于64、链表项长度超过8
4、数组Node项涵盖的属性为hash、key、value、链表next节点
5、hash值计算算法 (h = key.hashCode()) ^ (h >>> 16);
6、指定了初始容量的情况，this.threshold = tableSizeFor(initialCapacity) threshold为2的n次方的由来


put逻辑：
根据传入的key计算hash值（首先调用对象hashCode方法-》 key.hashCode()) ^ (h >>> 16)）计算得到hash值。
如果数组为空，首先数组调用reSize方法扩容。
如果该数组item项不存在(实现逻辑：根据传入的key，计算数组index位置：tab[i = (n - 1) & hash]),创建一个Node节点并赋值给当前tab[index]。
非链表节点、非树化：比对当前元素key是否相等，相等就replace
树化：红黑树添加方法
链表：尾插法

树化满足两个条件：1、binCount >= TREEIFY_THRESHOLD - 1 2、tab != null || (n = tab.length) >= MIN_TREEIFY_CAPACITY

resize逻辑：减少hash冲突，提高读取效率尽可能达到 o(1)
1、oldCap >= MAXIMUM_CAPACITY,threshold = Integer.MAX_VALUE
2、(newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                       oldCap >= DEFAULT_INITIAL_CAPACITY；newThr = oldThr << 1; // double threshold
3、newCap = DEFAULT_INITIAL_CAPACITY;
              newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
4、扩容后，数据迁移 （涉及到算法优化） 1111-11111

treeifyBin树化：
1、满足 tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY 只扩容，否则树化

remove逻辑：
1、数组不为空并且长度大于0的情况；计算得到待删除的数组hash位置，hash逻辑同put一样
2、比对成功（只有一个元素，链表，红黑树），如果是链表涉及到  p.next = node.next; 最后--size；
if (node instanceof TreeNode)
    ((TreeNode<K,V>)node).removeTreeNode(this, tab, movable);
else if (node == p)
    tab[index] = node.next;
else
     p.next = node.next;

replace逻辑：
1、新值替换旧值
2、返回旧值


heapSort:堆排序
1、heap基于二叉堆的完全二叉树，一般用一维数组实现
数组索引i的规律：
  如果i==0,它是根节点
  如果i>0,它的父节点的索引为floor(i-1)/2
  如果2i+1<=n-1,它的左子节点的索引为2i+1 --n为数组长度
  如果2i+1>n-1,它无子节点
  
  如果2i+2<=n-1,它的右子节点为2i+2
  如果2i+2>n-1,它无子节点
批量建堆，有2种办法：
  自上而下的上虑
  for(int i=1;i<size;i++){
    siftup(i);
  }
  自下而上的下虑
  for(int i=(size>>1)-1,i>=0;i--){
    siftDown(i);
  }







