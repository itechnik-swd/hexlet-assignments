package exercise;

import java.util.Map;

// BEGIN
class SingleTag extends Tag {

    public SingleTag(String tagName, Map<String, String> tagAttributes) {
        super(tagName, tagAttributes);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("<" + getTagName());
        for (Map.Entry<String, String> entry : getTagAttributes().entrySet()) {
            result.append(" ")
                .append(entry.getKey())
                .append("=\"")
                .append(entry.getValue())
                .append("\"");
        }
        result.append(">");
        return result.toString();
    }
}
// END
