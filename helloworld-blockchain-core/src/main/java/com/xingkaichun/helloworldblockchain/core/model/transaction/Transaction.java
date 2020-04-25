package com.xingkaichun.helloworldblockchain.core.model.transaction;


import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

/**
 * 交易
 */
@Data
public class Transaction implements Serializable {

    //交易时间戳
    private long timestamp;
    /**
     * 交易的Hash是交易的摘要。交易的哈希确定了，具体的交易也就确定了。
     *
     * 区块链系统不允许同一个[交易的Hash]被使用两次或是两次以上。
     * 这个值的构成应当足够简单去验证这个值是否是唯一的。
     * 当区块数据足够庞大时，用户节点只有最近一部分区块与UTXO数据，这时节点必须也可以校验它的唯一性。
     * 这里建议它的构成是一串字符+时间戳。
     * 最近的区块只包含最近产生的交易，因此只要有最近的区块就可校验它的唯一性。
     *
     * 这个字段也可以用来表示一张独一无二的区块编号
     * 还有另外一个独一无二的编号，区块高度+交易在区块中的编号，这个编号有个缺点，只能在区块完全确定后，才能确定这个编号
     */
    private String transactionHash;
    /**
     * 交易类型
     * 冗余
     */
    private TransactionType transactionType;
    //交易输入
    private List<TransactionInput> inputs;
    //交易输出
    private List<TransactionOutput> outputs;

    /**
     * 在区块中的交易序列号
     * 冗余
     */
    private BigInteger transactionSequenceNumberInBlock;
    /**
     * 在区块链中交易序列号
     * 冗余
     */
    private BigInteger transactionSequenceNumberInBlockChain;
    /**
     * 交易所在区块的区块高度
     * 冗余
     */
    private BigInteger blockHeight;
}