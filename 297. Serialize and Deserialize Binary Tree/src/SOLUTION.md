##Serialization
Stack used to go through tree starting from a far left branch.

`null` is used for non-existing nodes. ` ` is used as separator.

Every final node will be followed by `null null`.

For example tree
```
  1
 / \
2   3
```
Will be serialized as 
```
1 2 null null 3 null null 
```

##Deserialization
Tree will be generated starting from the top node, and a far left branch.

Stack of a branch will be used.

If `null` is met, that means that deserializer should stay on this node and read next value as right child. I'm using a boolean flag to do it. If right node is not null - moving forward on left side.

If case when second `null` is met, deserialized leaves a current node and moves on a branch up until it's empty or node with empty right child has been found.

###Notes
 - Recursion not used
 - Code has been submitted on a Leetcode and passed
 - All logic in `Codec.java`
 