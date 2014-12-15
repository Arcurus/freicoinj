package com.google.bitcoin.core;

import java.math.BigInteger;
import java.util.Date;
import java.util.Map;
import java.util.Vector;

public class CoinDefinition {

    public static final String coinName = "Freicoin";
    public static final String coinTicker = "FRC";
    public static final String coinURIScheme = "freicoin";
    public static final String cryptsyMarketId = "39";
    public static final String cryptsyMarketCurrency = "BTC";
    public static final String PATTERN_PRIVATE_KEY_START = "5";
    public static final String PATTERN_PRIVATE_KEY_START_COMPRESSED = "[L]";
    public static final String PATTERN_PRIVATE_KEY_START_TESTNET = "9";
    public static final String PATTERN_PRIVATE_KEY_START_COMPRESSED_TESTNET = "c";

    public static String lowerCaseCoinName() { return coinName.toLowerCase(); }

    public enum CoinPrecision {
        Coins,
        Millicoins,
    }
    public static final CoinPrecision coinPrecision = CoinPrecision.Coins;


    public static final String BLOCKEXPLORER_BASE_URL_PROD = "http://coinplorer.com/FRC/";   
    public static final String BLOCKEXPLORER_ADDRESS_PATH = "Addresses/";            
    public static final String BLOCKEXPLORER_TRANSACTION_PATH = "Transactions/";              
    public static final String BLOCKEXPLORER_BLOCK_PATH = "Blocks/";           
    public static final String BLOCKEXPLORER_BASE_URL_TEST = BLOCKEXPLORER_BASE_URL_PROD;

    public static final String DONATION_ADDRESS = "1G3ePcmEXRpvyX5nCTq1tt4coMkvY4ADPb";

    public static final String UNSPENT_API_URL = "http://dgc.blockr.io/api/v1/address/unspent/";
    public enum UnspentAPIType {
        BitEasy,
        Blockr,
        Abe
    };
    public static final UnspentAPIType UnspentAPI = UnspentAPIType.Blockr;

    enum CoinHash {
        SHA256,
        scrypt,
    };
    public static final CoinHash coinPOWHash = CoinHash.SHA256;

    public static boolean checkpointFileSupport = true;
    public static int checkpointDaysBack = 21;
 
    public static int spendableCoinbaseDepth = 100; //main.h: static const int COINBASE_MATURITY
    public static final BigInteger MAX_MONEY = BigInteger.valueOf(100000000).multiply(Utils.COIN);                 //masin.h:  MAX_MONEY

    //public static final BigInteger DEFAULT_MIN_TX_FEE = BigInteger.valueOf(1000*1000*10);   // MIN_TX_FEE
    public static final BigInteger DUST_LIMIT = BigInteger.valueOf(1); //main.h CTransaction::GetMinFee        0.01 coins

    public static final int PROTOCOL_VERSION = 70001;          //version.h PROTOCOL_VERSION
    public static final int MIN_PROTOCOL_VERSION = 60002;        //version.h MIN_PROTO_VERSION - eliminate 60001 which are on the wrong fork

    public static final int BLOCK_CURRENTVERSION = 1;   //CBlock::CURRENT_VERSION
    public static final int MAX_BLOCK_SIZE = 1 * 1000 * 1000;


    public static final boolean supportsBloomFiltering = false; //Requires PROTOCOL_VERSION 70000 in the client
    public static boolean supportsIrcDiscovery() {
        return PROTOCOL_VERSION <= 70000;
    }

    public static final int Port    = 8639;       //protocol.h GetDefaultPort(testnet=false)
    public static final int TestPort = 17999;     //protocol.h GetDefaultPort(testnet=true)

    //
    //  Production
    //
    public static final int AddressHeader = 0;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS
    public static final int p2shHeader = 5;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS
    public static final boolean allowBitcoinPrivateKey = true; // allow bitcoin private keys
    public static final long PacketMagic = 0x2CFE7E6D;      // 0x2C, 0xFE, 0x7E, 0x6D

    //Genesis Block Information from main.cpp: LoadBlockIndex
    static public long genesisBlockDifficultyTarget = (0x1d00ffffL);         //main.cpp: LoadBlockIndex
    static public long genesisBlockTime = 1356123600L;                       //main.cpp: LoadBlockIndex
    static public long genesisBlockNonce = (278229610);                         //main.cpp: LoadBlockIndex
    static public String genesisHash = "000000005b1e3d23ecfd2dd4a6e1a35238aa0392c0a8528c40df52376d7efe2c"; //main.cpp: hashGenesisBlock

    //taken from the raw data of the block explorer
    static public String genesisTxInBytes = "04ffff001d01044554656c6567726170682032372f4a756e2f3230313220426172636c61797320686974207769746820c2a33239306d2066696e65206f766572204c69626f7220666978696e67";

    //net.cpp strDNSSeed
    static public String[] dnsSeeds = new String[] {
            "185.5.53.132",
            "seed.freico.in",
            "seed.mainnet.freicoin.pw",
    };

    public static int minBroadcastConnections = 1;   //0 for default; we need more peers.

    //
    // TestNet - freicoin - not tested
    //
    public static final boolean supportsTestNet = false;
    public static final int testnetAddressHeader = 111;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS_TEST
    public static final int testnetp2shHeader = 196;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS_TEST
    public static final long testnetPacketMagic = 0xfcc1b7dc;      //0xfc, 0xc1, 0xb7, 0xdc
    public static final String testnetGenesisHash = "5e039e1ca1dbf128973bf6cff98169e40a1b194c3b91463ab74956f413b2f9c8";
    static public long testnetGenesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockTime = 999999L;                       //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockNonce = (99999);                         //main.cpp: LoadBlockIndex

    public static int subsidyDecreaseBlockCount = 161280;     //main.cpp GetBlockValue(height, fee)

    public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x1d00ffffL);  //main.cpp bnProofOfWorkLimit
    static public String[] testnetDnsSeeds = new String[] {
          "not supported"
    };
    //from main.h: CAlert::CheckSignature
    public static final String SATOSHI_KEY = "04EF014B36647E8433A2CEDF76F1D6EA0BC5914BA936FADCEDA90D7472DA3CF442469D3A1AB5EE416E7428726761DD3188BDA3D0AE163DB491F8CA0BDAD92A0506";
    public static final String TESTNET_SATOSHI_KEY = "";

    /** The string returned by getId() for the main, production network where people trade things. */
    public static final String ID_MAINNET = "org.freicoin.production";
    /** The string returned by getId() for the testnet. */
    public static final String ID_TESTNET = "org.freicoin.test";
    /** Unit test network. */
    public static final String ID_UNITTESTNET = "com.google.freicoin.unittest";

    //checkpoints.cpp Checkpoints::mapCheckpoints
    public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints){}

    //Unit Test Information
    public static final String UNITTEST_ADDRESS = "137tNPjiAbkavQbsT52RuUaTsYKoXDh4aa";
    public static final String UNITTEST_ADDRESS_PRIVATE_KEY = "5J9fvtAzDzED5vRR6KSKLpH4buZyuX2j2rLjgzHsyiRhMoPn4oA";

}
