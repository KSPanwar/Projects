package Transaction;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;

import Block.StringUtil;

public class transaction {
    public String transactionId;
    public PublicKey senderKey;
    public PublicKey receipentKey;
    public float value;
    public byte[] signature;

    public ArrayList<TransactionInput> inputs = new ArrayList<TransactionInput>();
    public ArrayList<TransactionOutput> outputs = new ArrayList<TransactionOutput>();

    private static int sequence =0;

    public transaction(PublicKey from,PublicKey to,float value,ArrayList<TransactionInput> inputs){
        this.senderKey = from;
        this.receipentKey=to;
        this.value=value;
        this.inputs = inputs;
    }


    private String calculateHash(){
        sequence++;
        return StringUtil.applySha256(StringUtil.getStringFromKey(senderKey) + StringUtil.getStringFromKey(receipentKey )+ Float.toString(value)+ sequence);
    }

    public void generateSignature(PrivateKey privateKey) {
	String data = StringUtil.getStringFromKey(senderKey) + StringUtil.getStringFromKey(receipentKey) + Float.toString(value)	;
	signature = StringUtil.applyECDSASig(privateKey,data);		
    }

    public boolean verifiySignature() {
	String data = StringUtil.getStringFromKey(senderKey) + StringUtil.getStringFromKey(receipentKey) + Float.toString(value)	;
	return StringUtil.verifyECDSASig(senderKey, data, signature);
    }
}
