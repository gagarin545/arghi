package ru.util.Arraytype;

public class IntArrayTypeDescriptor        extends AbstractArrayTypeDescriptor<int[]> {

    static final IntArrayTypeDescriptor INSTANCE =            new IntArrayTypeDescriptor();

    private IntArrayTypeDescriptor() {
        super( int[].class );
    }

    @Override
    protected String getSqlArrayType() {
        return "integer";
    }
}
