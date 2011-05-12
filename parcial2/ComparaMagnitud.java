public abstract class ComparaMagnitud implements ConMagnitud{
    public int compareTo(ConMagnitud otro){
        return (int)Math.ceil(this.getMagnitud() - otro.getMagnitud());
    }
}
