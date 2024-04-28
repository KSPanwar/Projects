package Block;
import java.util.ArrayList;

public class BlockChain {
    public static ArrayList<Block> blockchainA = new ArrayList<Block>();
    public static int difficulty = 5;
    public static void main(String[] args) {
        
        blockchainA.add(new Block("Hi im the first block", "0"));
        System.out.println("Trying to mine block");
        blockchainA.get(0).mineBlock(difficulty);


		blockchainA.add(new Block("Yo im the second block",blockchainA.get(blockchainA.size()-1).hash));
        System.out.println("Trying to mine block");
        blockchainA.get(1).mineBlock(difficulty);


		blockchainA.add(new Block("Hey im the third block",blockchainA.get(blockchainA.size()-1).hash));
		System.out.println("Trying to mine block");
        blockchainA.get(2).mineBlock(difficulty);

        System.out.println("\nBlockchain is Valid: " + isValid());

        for (Block block : blockchainA) 
            block.printBlockData();
            System.out.println(); // Add a line break between blocks
        }

        public static boolean isValid(){
            Block currentBlock;
            Block previousBlock;
            for(int i=1;i<blockchainA.size();i++){
                currentBlock = blockchainA.get(i);
                previousBlock = blockchainA.get(i-1);
                if(!currentBlock.hash.equals(currentBlock.calculateHash())){
                    return false;
                }
                if(!currentBlock.previousHash.equals(previousBlock.hash)){
                    return false;
                }
            }
            return true;
        }
    }

