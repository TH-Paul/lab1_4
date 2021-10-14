package demo;

public class Main {

    public static int billigste_tastatur(int[] tastaturen){
        int min = tastaturen[0];

        //parcurgem array-ul si salvam min
        for (int i = 1; i < tastaturen.length; i++){
            if (tastaturen[i] < min){
                min = tastaturen[i];
            }
        }

        return min;
    }

    public static int teuerster_gegenstand(int[] tastaturen, int[] usb){
        int max = 0;

        //parcurgem fiecare array si salvam max
        for (int a : tastaturen){
            if (a > max){
                max = a;
            }
        }

        for (int a : usb){
            if (a > max){
                max = a;
            }
        }

        return max;
    }

    public static int teuerster_usb(int[] usb, int budget){
        //pentru a obtine elementul cautat, trebuie sa gasim
        //produsul pentru care diferenta dintre buget si pret este minima

        int min = 0;

        //verificam si daca gasim un element in bugetul respectiv
        boolean found = false;
        int contor = 0;
        for(int a : usb){
            //min trebuie sa fie mai mare decat 0
            if (budget - a > 0){
                min = budget - a;
                found = true;
                break;
            }
            contor += 1;
        }


        //parcurgem array-ul si salvam min
        for (int i = contor + 1; i < usb.length; i++){
            if (budget - usb[i] < min && budget - usb[i] > 0){
                min = budget - usb[i];
            }
        }

        if (!found){
            return 0;
        }

        return budget - min;
    }

    public static int max_geldbetrag(int budget, int[] tastaturen, int[] usb){

        //pentru a obtine suma cautata, trebuie sa gasim
        //produsele pentru care diferenta dintre buget si preturi este minima
        int min = 0;

        //verificam si daca gasim 2 elemente in bugetul respectiv
        boolean found = false;

        int contor = 0;

        for(int a : tastaturen){
            //min trebuie sa fie mai mare decat 0
            for(int b : usb){
                if((budget - a - b) > 0){
                    min = budget - a - b;
                    found = true;
                    break;
                }
            }
            if(found){
                break;
            }
            contor += 1;
        }

        //parcurgem array-urile si salvam min
        for (int i = contor; i < tastaturen.length; i++){
            for(int j = 0; j < usb.length; j++){
                if(budget - tastaturen[i] - usb[j] < min && budget - tastaturen[i] - usb[j] > 0){
                    min = budget - tastaturen[i] - usb[j];
                }
            }
        }

        if (!found){
            return -1;
        }

        return budget - min;
    }

    public static void main(String[] args) {
        int[] tastaturen = new int[]{40, 35, 70, 15, 45};
        System.out.println("\nPreis des billigsten Tastaturs: " + String.valueOf(billigste_tastatur(tastaturen)));

        int[] tastaturen2 = new int[]{15, 20, 10, 35};
        int[] usb = new int[]{20, 15, 40, 15};
        System.out.println("\nPreis des teuersten Gegenstandes: " + String.valueOf(teuerster_gegenstand(tastaturen2, usb)));

        int[] usb2 = new int[]{15, 45, 20};
        int budget = 30;
        System.out.println("\nTeuerste USB Laufwerk, das Markus kaufen kann: " + String.valueOf(teuerster_usb(usb2, budget)));

        int budget2 = 60;
        int[] tastaturen3 = new int[]{40, 50, 60};
        int[] usb3 = new int[]{8, 12};
        int[] tastaturen4 = new int[]{60};
        int[] tastaturen5 = new int[]{40, 60};
        System.out.println("\nMaximaler Geldbetrag, der von Markus ausgegeben wird: " + String.valueOf(max_geldbetrag(budget2, tastaturen3, usb3)));
        System.out.println("\nMaximaler Geldbetrag, der von Markus ausgegeben wird: " + String.valueOf(max_geldbetrag(budget2, tastaturen4, usb3)));
        System.out.println("\nMaximaler Geldbetrag, der von Markus ausgegeben wird: " + String.valueOf(max_geldbetrag(budget2, tastaturen5, usb3)));
    }
}
