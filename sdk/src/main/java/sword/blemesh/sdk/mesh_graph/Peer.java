package sword.blemesh.sdk.mesh_graph;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by davidbrodsky on 2/21/15.
 */
public class Peer {


    private byte[] publicKey;
    private String alias;
    private String MacAddress;
    private Date lastSeen;
    private int rssi;
    protected int transports;

    public Peer(byte[] publicKey,
                   String alias,
                   String MacAddress,
                   Date lastSeen,
                   int rssi,
                   int transports) {

        this.publicKey = publicKey;
        this.alias = alias;
        this.MacAddress = MacAddress;
        this.lastSeen = lastSeen;
        this.rssi = rssi;
        this.transports = transports;
    }

    public byte[] getPublicKey() {
        return publicKey;
    }

    public String getAlias() {
        return alias;
    }

    public String getMacAddress() {return MacAddress;}

    public Date getLastSeen() {
        return lastSeen;
    }

    public int getRssi() {
        return rssi;
    }

    /**
     * To directed devices, use this method to set the RSSI of it.
     * @param rssi indicates the Signal Strength of remote device to local.
     */
    public void setRssi (int rssi){
        this.rssi = rssi;
    }

    public int getTransports() {
        return transports;
    }

    public boolean supportsTransportWithCode(int transportCode) {
        return (transports & transportCode) == transportCode;
    }

    @Override
    public String toString() {
        return "Peer{" +
                "publicKey=" + Arrays.toString(publicKey) +
                ", alias='" + alias + '\'' +
                ", lastSeen=" + lastSeen +
                ", rssi=" + rssi +
                '}';
    }

    @Override
    public boolean equals(Object obj) {

        if(obj == this) return true;
        if(obj == null) return false;

        if (getClass().equals(obj.getClass()))
        {
            Peer other = (Peer) obj;
            return Arrays.equals(publicKey, other.publicKey);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(publicKey);
    }
}
