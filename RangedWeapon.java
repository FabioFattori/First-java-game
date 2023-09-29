import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class RangedWeapon extends Weapon{
    private List<Bullet> bulletsShoted;

    public RangedWeapon(int attackSpeed, int damage, int range, int speed){
        super(attackSpeed, damage, range, speed);
        bulletsShoted = new List<Bullet>() {

            @Override
            public int size() {
                return bulletsShoted.size();
            }

            @Override
            public boolean isEmpty() {
                if(bulletsShoted.size() == 0)
                    return true;
                return false;
            }

            @Override
            public boolean contains(Object o) {
               for (Bullet bullet : bulletsShoted) {
                if(bullet.equals(o))
                    return true;
               }
               return false;
            }

            @Override
            public Iterator<Bullet> iterator() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'iterator'");
            }

            @Override
            public Object[] toArray() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'toArray'");
            }

            @Override
            public <T> T[] toArray(T[] a) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'toArray'");
            }

            @Override
            public boolean add(Bullet e) {
                bulletsShoted.add(e);
                return true;
            }

            @Override
            public boolean remove(Object o) {
                bulletsShoted.remove(o);
                return true;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                for (Object object : c) {
                    for (Bullet b : bulletsShoted) {
                        if(!b.equals(object)){
                            return false;
                        }
                    }
                }

                return true;
            }

            @Override
            public boolean addAll(Collection<? extends Bullet> c) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'addAll'");
            }

            @Override
            public boolean addAll(int index, Collection<? extends Bullet> c) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'addAll'");
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'removeAll'");
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'retainAll'");
            }

            @Override
            public void clear() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'clear'");
            }

            @Override
            public Bullet get(int index) {
                return bulletsShoted.get(index);
            }

            @Override
            public Bullet set(int index, Bullet element) {
                bulletsShoted.set(index, element);
                return element;
            }

            @Override
            public void add(int index, Bullet element) {
                bulletsShoted.add(index, element);
            }

            @Override
            public Bullet remove(int index) {
                bulletsShoted.remove(index);
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return bulletsShoted.indexOf(o);
            }

            @Override
            public int lastIndexOf(Object o) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'lastIndexOf'");
            }

            @Override
            public ListIterator<Bullet> listIterator() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
            }

            @Override
            public ListIterator<Bullet> listIterator(int index) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
            }

            @Override
            public List<Bullet> subList(int fromIndex, int toIndex) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'subList'");
            }
            
        };
    }
}
