public class Buffer{

    BufferedWriter bw = new BufferedWriter(new FileWriter(file));
    bw.write("<html><head><title>New Page</title></head><body><p>Eric and David's Dictionary</p></body></html>/n");
    bw.close();
}