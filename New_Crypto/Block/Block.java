package Block;

import java.util.Date;

public class Block{
    public String hash;
    public String previousHash;
    private String blockData;
    private long timeStamp;
    private int nonce;
  

    public Block(String blockData,String previousHash ){
        this.blockData = blockData;
        this.previousHash= previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    StringUtil s = new StringUtil();

    public  String calculateHash(){
        String valueofHash = StringUtil.applySha256(blockData+previousHash+timeStamp + Integer.toString(nonce));
        return valueofHash;
    }

    public void printBlockData() {
        System.out.println("Block Data:");
        System.out.println("Data: " + blockData);
        System.out.println("Hash: " + hash);
        System.out.println("Previous Hash: " + previousHash);
    }

   

    public void mineBlock(int difficulty) {
		String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0" 
		while(!hash.substring( 0, difficulty).equals(target)) {
			nonce ++;
			hash = calculateHash();
		}
		System.out.println("Block Mined!!! : " + hash);
	}

}