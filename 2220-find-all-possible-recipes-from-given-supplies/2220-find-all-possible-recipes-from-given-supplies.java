class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> ingAvailable = new HashSet<>(Arrays.asList(supplies));
        Set<String> result = new HashSet<>();
        boolean updated = true;
        while (updated) {
            updated = false;
            for (int i = 0; i < recipes.length; i++) {
                String recp = recipes[i];
                if(result.contains(recp))
                    continue;
                boolean canMake = true;
                for (String ing : ingredients.get(i)) {
                    //System.out.println(ing);
                    if (!ingAvailable.contains(ing)) {
                        canMake = false;
                        break;
                    }
                }

                if (canMake) {
                    ingAvailable.add(recp);
                    result.add(recp);
                    updated = true;
                    //break;
                }

            }
        }

        return new ArrayList<>(result);
    }
}