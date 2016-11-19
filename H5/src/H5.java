
public class H5 {
	
	
	
	    
    public static boolean isBST(BSTnode<K> root){
        if(root==null){
            return true;
            }

        if(root.getLeft()  == null && root.getRight() == null){
            return true;
        }

    if(root.getLeft().getKey().compareTo(root.getKey()) >= 0 || root.getRight().getKey().compareTo(root.getKey()) <= 0 ){
        return false;
    }
    
    BSTnode<K> tempLeft=new BSTnode<K>(null,null,null);
    BSTnode<K> tempRight=new BSTnode<K>(null,null,null);;
    
    if(root.getLeft()!=null){
        tempLeft=root.getLeft();
        while(tempLeft.getRight()!=null){
            tempLeft=tempLeft.getRight();
            if(tempLeft.getKey().compareTo(root.getKey()) >= 0){
                return false;    
            }
        }
    }

    if(root.getRight()!=null){
        tempRight=root.getRight();
        while(tempRight.getLeft()!=null){//
            tempRight=tempRight.getLeft();//
            if(tempRight.getKey().compareTo(root.getKey()) <= 0){
                return false;    
            }
        }
    }

   
    return(  isBST( root.getLeft() )&& isBST( root.getRight() )   );
        
    
    
    }

	

}
